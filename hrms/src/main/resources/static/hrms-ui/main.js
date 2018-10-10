(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"./super-admin/super-admin.module": [
		"./src/app/super-admin/super-admin.module.ts",
		"super-admin-super-admin-module"
	],
	"./users/users.module": [
		"./src/app/users/users.module.ts",
		"users-users-module"
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];
	if(!ids) {
		return Promise.resolve().then(function() {
			var e = new Error("Cannot find module '" + req + "'");
			e.code = 'MODULE_NOT_FOUND';
			throw e;
		});
	}
	return __webpack_require__.e(ids[1]).then(function() {
		var id = ids[0];
		return __webpack_require__(id);
	});
}
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
webpackAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";
module.exports = webpackAsyncContext;

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _entry_entry_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./entry/entry.component */ "./src/app/entry/entry.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var routes = [
    { path: '', component: _entry_entry_component__WEBPACK_IMPORTED_MODULE_2__["EntryComponent"] },
    { path: 'user', loadChildren: './users/users.module#UsersModule' },
    { path: 'super-user', loadChildren: './super-admin/super-admin.module#SuperAdminModule' }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes, { useHash: true })],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"wrapper\">\r\n  <!-- Sidebar  -->\r\n  <app-sidebar *ngIf=\"!fakeLoginauth\"></app-sidebar>\r\n  <!-- Page Content  -->\r\n  <div id=\"content\">\r\n  <app-navbar *ngIf=\"!fakeLoginauth\"></app-navbar>\r\n  <router-outlet></router-outlet>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "./src/app/app.component.scss":
/*!************************************!*\
  !*** ./src/app/app.component.scss ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'app';
        this.fakeLoginauth = false;
    }
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.scss */ "./src/app/app.component.scss")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var angular2_text_mask__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! angular2-text-mask */ "./node_modules/angular2-text-mask/dist/angular2TextMask.js");
/* harmony import */ var angular2_text_mask__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(angular2_text_mask__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _includes_navbar_navbar_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./includes/navbar/navbar.component */ "./src/app/includes/navbar/navbar.component.ts");
/* harmony import */ var _includes_sidebar_sidebar_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./includes/sidebar/sidebar.component */ "./src/app/includes/sidebar/sidebar.component.ts");
/* harmony import */ var _entry_entry_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./entry/entry.component */ "./src/app/entry/entry.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};








var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"],
                _includes_navbar_navbar_component__WEBPACK_IMPORTED_MODULE_5__["NavbarComponent"],
                _includes_sidebar_sidebar_component__WEBPACK_IMPORTED_MODULE_6__["SidebarComponent"],
                _entry_entry_component__WEBPACK_IMPORTED_MODULE_7__["EntryComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_3__["AppRoutingModule"],
                angular2_text_mask__WEBPACK_IMPORTED_MODULE_2__["TextMaskModule"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/entry/entry.component.html":
/*!********************************************!*\
  !*** ./src/app/entry/entry.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"m-md-5 m-sm-0 entry-card\">\r\n  <div class=\"card border-0 shadow h-100 m-auto\">\r\n    <div class=\"row\">\r\n      <div class=\"col-md-5 col-sm-12 h-100\">\r\n        <div class=\"banner\">\r\n          <img class=\"img-parallax rounded-left\" src=\"assets/static/backgrounds/login-bac.png\" />\r\n        </div>\r\n      </div>\r\n      <div class=\"col-md-7 col-sm-12 h-100\">\r\n        <div class=\"p-md-5 p-sm-2\">\r\n          <span class=\"entry-head font-weight-light mb-3\">Welcome to <span class=\"font-weight-bold\">HRMS</span></span>\r\n          <ul class=\"nav nav-tabs border-0\" id=\"myTab\" role=\"tablist\">\r\n            <li class=\"nav-item mx-1\">\r\n              <a class=\"nav-link login-tabs rounded border-0 active\" id=\"signin-tab\" data-toggle=\"tab\" href=\"#signin\"\r\n                role=\"tab\" aria-controls=\"signin\" aria-selected=\"true\"> </a>\r\n            </li>\r\n            <li class=\"nav-item mx-1\">\r\n              <a class=\"nav-link login-tabs rounded border-0\" id=\"signup-tab\" data-toggle=\"tab\" href=\"#signup\" role=\"tab\"\r\n                aria-controls=\"signup\" aria-selected=\"false\"> </a>\r\n            </li>\r\n          </ul>\r\n          <div class=\"tab-content\" id=\"myTabContent\">\r\n            <div class=\"tab-pane fade show active\" id=\"signin\" role=\"tabpanel\" aria-labelledby=\"signin-tab\">\r\n             <div class=\"m-md-2 m-sm-1\">\r\n               <div class=\"card m-auto border-0\">\r\n                <div class=\"div-center\">\r\n                  <div class=\"row\">\r\n                    <div class=\"col-md-8 col-sm-12\">\r\n                      <form>\r\n                        <div class=\"form-group\">\r\n                          <label class=\"form-label\" for=\"Email\">\r\n                            <img src=\"assets/static/icons/login/avatar.svg\">\r\n                          </label>\r\n                          <input type=\"email\" class=\"form-control login-form rounded-top\" id=\"Email\" aria-describedby=\"emailHelp\"\r\n                            placeholder=\"Username\">\r\n                          <label class=\"form-label\" for=\"Password\">\r\n                            <img src=\"assets/static/icons/login/key.svg\">\r\n                          </label>\r\n                          <input type=\"password\" class=\"form-control login-form rounded-bottom\" id=\"Password\" placeholder=\"Password\">\r\n                        </div>\r\n                        <div class=\"form-group form-check\">\r\n                          <div class=\"custom-control custom-checkbox\">\r\n                            <input type=\"checkbox\" class=\"custom-control-input\" id=\"RememberCheck\">\r\n                            <label class=\"custom-control-label\" for=\"RememberCheck\">Remember me</label>\r\n                          </div>\r\n                        </div>\r\n                        <button type=\"submit\" class=\"btn btn-custom btn-blue text-white shadow-sm w-100 m-0\">Sign In</button>\r\n                        <div class=\"text-center my-4\">\r\n                          <a href=\"#\">Need Help accessing your account?</a>\r\n                        </div>\r\n                      </form>\r\n                      <hr>\r\n                      <div class=\"my-2\">\r\n                        <div class=\"card bg-transparent\">\r\n                          <div class=\"card-body p-3 text-center\">\r\n                            <p class=\"m-0\"><a id=\"signup-tab\" data-toggle=\"tab\" href=\"#signup\" role=\"tab\" aria-controls=\"signup\"\r\n                                aria-selected=\"false\">Create an Account</a> or <a href=\"#\">Request Demo</a></p>\r\n                          </div>\r\n                        </div>\r\n                      </div>\r\n                    </div>\r\n                  </div>\r\n                </div>\r\n               </div>\r\n             </div>\r\n            </div>\r\n            <div class=\"tab-pane fade\" id=\"signup\" role=\"tabpanel\" aria-labelledby=\"signup-tab\">\r\n              <div class=\"row\">\r\n                <form>\r\n                  <div class=\"form-row m-3\">\r\n                    <div class=\"col-md-6 col-sm-12\">\r\n                      <input type=\"text\" class=\"form-control\" placeholder=\"First name\">\r\n                    </div>\r\n                    <div class=\"col-md-6 col-sm-12\">\r\n                      <input type=\"text\" class=\"form-control\" placeholder=\"Last name\">\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"form-row m-3\">\r\n                    <div class=\"col-md-8 col-sm-12\">\r\n                      <input type=\"email\" class=\"form-control\" placeholder=\"Email Address\">\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"form-row m-3\">\r\n                    <div class=\"col-md-8 col-md-12\">\r\n                      <input type=\"password\" class=\"form-control\" placeholder=\"Password\">\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"form-row m-3\">\r\n                    <div class=\"col-md-7 col-sm-12\">\r\n                      <input type=\"text\" class=\"form-control\" placeholder=\"Company Name\">\r\n                    </div>\r\n                    <div class=\"col-md-2 col-sm-12\">\r\n                      <input type=\"text\" class=\"form-control\" placeholder=\"Zip Code\">\r\n                    </div>\r\n                    <div class=\"col-md-3 col-sm-12\">\r\n                      <input type=\"text\" class=\"form-control\" [textMask]=\"{mask: phonemask}\" placeholder=\"(___) ___-____\">\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"form-row m-3\">\r\n                    <div class=\"col-md-8 col-sm-12\">\r\n                      <input type=\"text\" class=\"form-control\" placeholder=\"www.example.com\">\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"form-row m-3\">\r\n                    <div class=\"col-md-6 col-sm-12\">\r\n                      <input type=\"text\" class=\"form-control\" placeholder=\"Number of Employees\">\r\n                    </div>\r\n                    <div class=\"col-md-6 col-sm-12\">\r\n                      <input type=\"text\" class=\"form-control\" placeholder=\"Your Role\">\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"form-row mt-3\">\r\n                    <div class=\"form-group pl-4 pt-1\">\r\n                      <div class=\"custom-control custom-checkbox\">\r\n                        <input class=\"custom-control-input\" type=\"checkbox\" id=\"regCheckBox\">\r\n                        <label class=\"custom-control-label\" for=\"regCheckBox\">\r\n                          I agree to HRMS <a href=\"#\">Terms</a> & <a href=\"#\">Privacy policy</a>.\r\n                        </label>\r\n                      </div>\r\n                    </div>\r\n                  </div>\r\n                  <div class=\"form-row m-3\">\r\n                    <div class=\"col-md-6 col-sm-12\">\r\n                      <button type=\"submit\" class=\"btn btn-custom btn-blue text-white shadow-sm w-100 m-0\">Sign\r\n                        Up</button>\r\n                    </div>\r\n                  </div>\r\n                </form>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "./src/app/entry/entry.component.scss":
/*!********************************************!*\
  !*** ./src/app/entry/entry.component.scss ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "/* A class that will respond differently in different resolutions */\n.sample-padding-class {\n  padding-bottom: 200%;\n  color: #FFF; }\n@media (min-width: 576px) {\n    .sample-padding-class {\n      padding-bottom: 100%;\n      color: #000; } }\n@media (min-width: 768px) {\n    .sample-padding-class {\n      padding-bottom: 50%; } }\n@media (min-width: 992px) {\n    .sample-padding-class {\n      padding-bottom: 10%; } }\n@media (min-width: 1200px) {\n    .sample-padding-class {\n      padding-top: 20%;\n      padding-bottom: 0;\n      color: #1337; } }\n.entry-card {\n  height: 80vh; }\n.entry-head {\n  font-size: 2.1rem; }\n.login-tabs {\n  height: 6px;\n  width: 70px;\n  padding: 0px;\n  background: #e0e2e4; }\n.login-tabs.active {\n    height: 6px;\n    width: 70px;\n    padding: 0px;\n    background: #0093de; }\n.login-form {\n  height: 55px !important;\n  padding-left: 50px; }\n.form-label {\n  position: absolute;\n  margin-top: 15px;\n  margin-left: 15px; }\n.form-label img {\n    height: 25px;\n    height: 25px; }\n.img-parallax {\n  position: relative;\n  left: 50%;\n  width: 100%;\n  height: 80vh;\n  -o-object-fit: cover;\n     object-fit: cover;\n  transform: translate3d(-50%, 0px, 0px);\n  -ms-transform: translate3d(-50%, 0px, 0px);\n  -webkit-transform: translate3d(-50%, 0px, 0px);\n  -o-transform: translate3d(-50%, 0px, 0px); }\n.div-center {\n  position: absolute;\n  left: 12%;\n  width: 100%;\n  margin-top: 25px; }\n@media screen and (max-width: 768px) {\n    .div-center {\n      left: 0%; } }\n"

/***/ }),

/***/ "./src/app/entry/entry.component.ts":
/*!******************************************!*\
  !*** ./src/app/entry/entry.component.ts ***!
  \******************************************/
/*! exports provided: EntryComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "EntryComponent", function() { return EntryComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var EntryComponent = /** @class */ (function () {
    function EntryComponent() {
        this.phonemask = ['(', /[0-9]/, /\d/, /\d/, ')', ' ', /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/];
    }
    EntryComponent.prototype.ngOnInit = function () {
    };
    EntryComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-entry',
            template: __webpack_require__(/*! ./entry.component.html */ "./src/app/entry/entry.component.html"),
            styles: [__webpack_require__(/*! ./entry.component.scss */ "./src/app/entry/entry.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], EntryComponent);
    return EntryComponent;
}());



/***/ }),

/***/ "./src/app/includes/navbar/navbar.component.html":
/*!*******************************************************!*\
  !*** ./src/app/includes/navbar/navbar.component.html ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-expand-lg navbar-light p-0\">\r\n  <div class=\"container-fluid\">\r\n\r\n    <button type=\"button\" id=\"sidebarCollapse\" class=\"btn rounded-circle shadow-sm bg-light\">\r\n      <i class=\"fa fa-bars\" aria-hidden=\"true\"></i>\r\n    </button>\r\n    <button class=\"btn btn-dark d-inline-block d-lg-none ml-auto\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\r\n      aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n      <i class=\"fas fa-align-justify\"></i>\r\n    </button>\r\n\r\n    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n      <ul class=\"navbar-nav ml-auto\">\r\n        <li class=\"nav-item pt-1 pr-2\">\r\n          <form action=\"\" class=\"search-form nav-link\">\r\n            <div class=\"form-group has-feedback\">\r\n              <label for=\"search\" class=\"sr-only\">Search</label>\r\n              <input type=\"text\" class=\"form-control\" name=\"search\" id=\"search\" placeholder=\"search\">\r\n              <i class=\"fa fa-search form-control-feedback\" aria-hidden=\"true\"></i>\r\n            </div>\r\n          </form>\r\n        </li>\r\n        <li class=\"nav-item dropdown pt-2 px-3 border-left\">\r\n          <a class=\"nav-link\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n            aria-expanded=\"false\">\r\n            <i class=\"fa fa-comment\" aria-hidden=\"true\"></i>\r\n            <span class=\"badge badge-pill badge-secondary shadow-sm\">1</span>\r\n          </a>\r\n          <div class=\"dropdown-menu user-dropdown rounded-0 border-0 shadow-sm p-0\" aria-labelledby=\"navbarDropdown\">\r\n            <div class=\"dropdown-header text-center bg-light border-0\">\r\n              <strong>You have 1 Messages</strong>\r\n            </div>\r\n            <a class=\"dropdown-item\" href=\"#\">\r\n              <div class=\"message\">\r\n                <div>\r\n                  <small class=\"text-muted\">John Doe</small>\r\n                  <small class=\"text-muted float-right mt-1\">Just now</small>\r\n                </div>\r\n                <div class=\"text-truncate font-weight-bold\">\r\n                  <span class=\"fa fa-exclamation text-danger\"></span> Important message</div>\r\n                <div class=\"small text-muted text-truncate\">Lorem ipsum dolor sit amet, consectetur adipisicing elit,\r\n                  sed\r\n                  do eiusmod tempor incididunt...</div>\r\n              </div>\r\n            </a>\r\n          </div>\r\n\r\n        </li>\r\n        <li class=\"nav-item dropdown pt-2 px-3 border-left\">\r\n          <a class=\"nav-link\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n            aria-expanded=\"false\">\r\n            <i class=\"fa fa-bell\" aria-hidden=\"true\"></i>\r\n            <span class=\"badge badge-pill badge-secondary shadow-sm\">1</span>\r\n          </a>\r\n          <div class=\"dropdown-menu user-dropdown rounded-0 border-0 shadow-sm p-0\" aria-labelledby=\"navbarDropdown\">\r\n            <div class=\"dropdown-header text-center bg-light border-0\">\r\n              <strong>You have 1 Notifications</strong>\r\n            </div>\r\n            <a class=\"dropdown-item\" href=\"#\">\r\n              <div class=\"message\">\r\n                <div>\r\n                  <small class=\"text-muted\">John Doe</small>\r\n                  <small class=\"text-muted float-right mt-1\">Just now</small>\r\n                </div>\r\n                <div class=\"text-truncate font-weight-bold\">\r\n                  <span class=\"fa fa-exclamation text-danger\"></span> Important message</div>\r\n                <div class=\"small text-muted text-truncate\">Lorem ipsum dolor sit amet, consectetur adipisicing elit,\r\n                  sed\r\n                  do eiusmod tempor incididunt...</div>\r\n              </div>\r\n            </a>\r\n          </div>\r\n\r\n        </li>\r\n        <li class=\"nav-item dropdown border-left\">\r\n          <a class=\"nav-link\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n            aria-expanded=\"false\">\r\n            <span class=\"px-2\">Giacobo Lefeaver</span>\r\n            <img class=\"user-portrait rounded-circle shadow\" src=\"assets/static/user01-320x320.jpg\">            \r\n          </a>\r\n          <div class=\"dropdown-menu user-dropdown rounded-0 border-0 shadow-sm p-0\" aria-labelledby=\"navbarDropdown\">\r\n            <div class=\"user-dropdown-info dropdown-info px-5 py-3\">\r\n              <div class=\"user-info-portrait\">\r\n                <img class=\"d-block m-auto rounded-circle shadow\" src=\"assets/static/user01-320x320.jpg\" />                 \r\n              </div>\r\n              <div class=\"text-center\">\r\n                <h4 class=\"font-weight-bold mb-0\">Giacobo Lefeaver</h4>\r\n                <small>Blue Space Technologies, INC</small>\r\n              </div>\r\n            </div>\r\n            <div class=\"dropdown-header bg-light border-0\">\r\n              <strong>Account</strong>\r\n            </div>\r\n            <a class=\"dropdown-item\" href=\"#\">Settings</a>\r\n            <a class=\"dropdown-item\" href=\"#\">Account Changes</a>\r\n            <a class=\"dropdown-item\" href=\"#\">Logout</a>\r\n          </div>\r\n        </li>\r\n      </ul>\r\n    </div>\r\n  </div>\r\n</nav>"

/***/ }),

/***/ "./src/app/includes/navbar/navbar.component.scss":
/*!*******************************************************!*\
  !*** ./src/app/includes/navbar/navbar.component.scss ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".user-dropdown {\n  left: -105px;\n  max-width: 290px; }\n\n.user-portrait {\n  height: 40px; }\n\n.user-info-portrait img {\n  height: 140px; }\n\n.search-form .form-group {\n  float: right !important;\n  transition: all 0.35s, border-radius 0s;\n  width: 32px;\n  height: 32px;\n  background-color: #fff;\n  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;\n  border-radius: 25px;\n  border: 1px solid #ccc; }\n\n.search-form .form-group input.form-control {\n    padding-left: 30px;\n    padding-bottom: 12px;\n    border: 0 none;\n    background: transparent;\n    box-shadow: none;\n    display: block; }\n\n.search-form .form-group input.form-control::-webkit-input-placeholder {\n      display: none; }\n\n.search-form .form-group input.form-control:-moz-placeholder {\n      /* Firefox 18- */\n      display: none; }\n\n.search-form .form-group input.form-control::-moz-placeholder {\n      /* Firefox 19+ */\n      display: none; }\n\n.search-form .form-group input.form-control:-ms-input-placeholder {\n      display: none; }\n\n.search-form .form-group:hover, .search-form .form-group.hover {\n    width: 100%;\n    border-radius: 25px; }\n\n.search-form .form-group i.form-control-feedback {\n    position: relative;\n    top: -36px;\n    left: 8px; }\n"

/***/ }),

/***/ "./src/app/includes/navbar/navbar.component.ts":
/*!*****************************************************!*\
  !*** ./src/app/includes/navbar/navbar.component.ts ***!
  \*****************************************************/
/*! exports provided: NavbarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NavbarComponent", function() { return NavbarComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var jquery__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! jquery */ "./node_modules/jquery/dist/jquery.js");
/* harmony import */ var jquery__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(jquery__WEBPACK_IMPORTED_MODULE_1__);
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var NavbarComponent = /** @class */ (function () {
    function NavbarComponent() {
    }
    NavbarComponent.prototype.ngOnInit = function () {
        jquery__WEBPACK_IMPORTED_MODULE_1__(document).ready(function () {
            jquery__WEBPACK_IMPORTED_MODULE_1__('#sidebarCollapse').on('click', function () {
                jquery__WEBPACK_IMPORTED_MODULE_1__('#sidebar').toggleClass('active');
            });
        });
    };
    NavbarComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-navbar',
            template: __webpack_require__(/*! ./navbar.component.html */ "./src/app/includes/navbar/navbar.component.html"),
            styles: [__webpack_require__(/*! ./navbar.component.scss */ "./src/app/includes/navbar/navbar.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], NavbarComponent);
    return NavbarComponent;
}());



/***/ }),

/***/ "./src/app/includes/sidebar/sidebar.component.html":
/*!*********************************************************!*\
  !*** ./src/app/includes/sidebar/sidebar.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav id=\"sidebar\">\r\n  <div class=\"sidebar-header\">\r\n    <h3>HRMS</h3>\r\n    <img src=\"assets/static/earth.svg\" />\r\n  </div>\r\n\r\n  <ul class=\"list-unstyled components p-3\">\r\n    <li>\r\n      <a routerLink=\"/user/home\">\r\n        <i class=\"fa fa-home\" aria-hidden=\"true\"></i>\r\n        <span class=\"szHide\">Home</span>\r\n      </a>\r\n    </li>\r\n    <li>\r\n      <a href=\"#\">\r\n        <i class=\"fa fa-address-book-o\" aria-hidden=\"true\"></i>\r\n        <span class=\"szHide\">About</span>\r\n      </a>\r\n      <a href=\"#pageSubmenu\" data-toggle=\"collapse\" aria-expanded=\"false\" class=\"dropdown-toggle\">\r\n        <i class=\"fa fa-file\" aria-hidden=\"true\"></i>\r\n        <span class=\"szHide\">Pages</span>\r\n      </a>\r\n      <ul class=\"collapse list-unstyled\" id=\"pageSubmenu\">\r\n        <li>\r\n          <a href=\"#\">Page 1</a>\r\n        </li>\r\n        <li>\r\n          <a href=\"#\">Page 2</a>\r\n        </li>\r\n        <li>\r\n          <a href=\"#\">Page 3</a>\r\n        </li>\r\n      </ul>\r\n    </li>\r\n    <li>\r\n      <a href=\"#\">\r\n        <i class=\"fa fa-file-image-o\" aria-hidden=\"true\"></i>\r\n        <span class=\"szHide\">Portfolio</span>\r\n      </a>\r\n    </li>\r\n    <li>\r\n      <a href=\"#\">\r\n        <i class=\"fa fa-question-circle\" aria-hidden=\"true\"></i>\r\n        <span class=\"szHide\">FAQ</span>\r\n      </a>\r\n    </li>\r\n    <li>\r\n      <a href=\"#\">\r\n        <i class=\"fa fa-paper-plane\" aria-hidden=\"true\"></i>\r\n        <span class=\"szHide\">Contact</span>\r\n      </a>\r\n    </li>\r\n  </ul>\r\n</nav>"

/***/ }),

/***/ "./src/app/includes/sidebar/sidebar.component.scss":
/*!*********************************************************!*\
  !*** ./src/app/includes/sidebar/sidebar.component.scss ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/includes/sidebar/sidebar.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/includes/sidebar/sidebar.component.ts ***!
  \*******************************************************/
/*! exports provided: SidebarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SidebarComponent", function() { return SidebarComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var SidebarComponent = /** @class */ (function () {
    function SidebarComponent() {
    }
    SidebarComponent.prototype.ngOnInit = function () {
    };
    SidebarComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-sidebar',
            template: __webpack_require__(/*! ./sidebar.component.html */ "./src/app/includes/sidebar/sidebar.component.html"),
            styles: [__webpack_require__(/*! ./sidebar.component.scss */ "./src/app/includes/sidebar/sidebar.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], SidebarComponent);
    return SidebarComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! D:\Lost Partition1(NTFS)\hrms\hrms-ui\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map