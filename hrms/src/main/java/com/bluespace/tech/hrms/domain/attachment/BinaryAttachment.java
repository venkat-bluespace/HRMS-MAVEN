package com.bluespace.tech.hrms.domain.attachment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.MongoClientException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "binaryattachment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinaryAttachment {

	static public enum MimeType {
		PDF("application/pdf"),
		TEXT("text/plain"),
		RTF("application/msword"),
		JPEG("image/jpeg"),
		TIFF("image/tiff"),
		EXCEL("application/vnd.ms-excel"),
		POSTSCRIPT("application/postscript"),
		UNSUPPORTED("unsupported");

		private String mimeIdentifier;

		MimeType(String mimeIdentifier) {
			this.mimeIdentifier = mimeIdentifier;
		}

		public String getMimeIdentifier() {
			return mimeIdentifier;
		}

		public void setMimeIdentifier(String mimeIdentifier) {
			this.mimeIdentifier = mimeIdentifier;
		}
	}

	@Getter @Setter @Id private ObjectId _id;
	@Getter @Setter private String name;
	@Getter @Setter private Date timestamp;
	@Getter @Setter private String description;
	@Getter @Setter private long size;
	@Getter @Setter private MimeType mimeType;
	@Getter @Transient private byte[] fileAttachment;
	@Getter @Setter private String publicId;
	@Getter @Setter private String title;
	@Getter @Setter private String url;
	@Getter @Setter private String clientId;
	@Getter @Setter private String imagePath;
	@Getter @Setter private boolean imageTransferred;
	
	public Blob getData() {
        return null;
    }

    public void setData(Blob fileBlob) {
        this.fileAttachment = this.toByteArray(fileBlob);
    }
    
    @Transient
    public void setFileAttachment(byte[] fileAttachment) {
        if (fileAttachment!=null && fileAttachment.length>0) {
            this.fileAttachment = fileAttachment;
            this.size = fileAttachment.length;
        }
    }
    
    private byte[] toByteArray(Blob blobData) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(blobData.getBytes(1, (int)blobData.length()));
            return baos.toByteArray();
        }
        catch (SQLException se) {
            throw new MongoClientException("MongoClientException: "+se);
        }
        catch (IOException ie) {
            throw new MongoClientException("MongoClientException: "+ie);
        }
        finally {
            try {
                baos.close();
            }
            catch (IOException e) {
            	
            }
        }
    }
    
    public String toString() {
        return 
             "id="+_id
           + " name="+name
           + " timestamp="+ timestamp
           + " description="+ description
           + " size="+ size
           + " mimeType="+ mimeType
           + " fileAttachment.length="+
                (fileAttachment==null ? "null" : fileAttachment.length)
        ;
    }
}
