package com.bluespace.tech.hrms.repositories.attachment;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bluespace.tech.hrms.domain.attachment.BinaryAttachment;

public interface BinaryAttachmentRepositry extends MongoRepository<BinaryAttachment, Long> {

}
