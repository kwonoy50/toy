DROP TABLE IF EXISTS BOARD;
CREATE TABLE BOARD (
    BOARD_NO      INT           NOT NULL,
    BOARD_TITLE   VARCHAR(200)  NOT NULL,
    BOARD_CONTENT VARCHAR(4000) NOT NULL,
    BOARD_USER_ID VARCHAR(50)   NOT NULL,
    BOARD_REGDATE DATE          NOT NULL,
    CONSTRAINT PK_BOARD UNIQUE (BOARD_NO)
);
COMMENT ON TABLE  BOARD               IS '게시판';
COMMENT ON COLUMN BOARD.BOARD_NO      IS '게시판 번호';
COMMENT ON COLUMN BOARD.BOARD_TITLE   IS '게시판 제목';
COMMENT ON COLUMN BOARD.BOARD_CONTENT IS '게시판 내용';
COMMENT ON COLUMN BOARD.BOARD_USER_ID IS '게시판 작성자 ID';
COMMENT ON COLUMN BOARD.BOARD_REGDATE IS '게시판 작성일';


DROP TABLE IF EXISTS _G_USER;
CREATE TABLE _G_USER (
    USER_ID     VARCHAR(30)  NOT NULL,
    USER_NAME   VARCHAR(50)  NOT NULL,
    USER_PASSWD VARCHAR(100) NOT NULL,
    CONSTRAINT PK_G_USER UNIQUE (USER_ID)
);
COMMENT ON TABLE  _G_USER             IS '사용자';
COMMENT ON COLUMN _G_USER.USER_ID     IS '사용자 ID';
COMMENT ON COLUMN _G_USER.USER_NAME   IS '사용자 명';
COMMENT ON COLUMN _G_USER.USER_PASSWD IS '사용자 비밀번호';


DROP TABLE IF EXISTS _G_BIND;
CREATE TABLE _G_BIND (
    BIND_ID             VARCHAR(50)  NOT NULL,
    BIND_METHOD         VARCHAR(10)  NOT NULL,
    BIND_NAME           VARCHAR(100) NOT NULL,
    BEAN_ID             VARCHAR(50)  NOT NULL,
    RESPONSE_VIEW_URI   VARCHAR(100),
    RESPONSE_LAYOUT_URI VARCHAR(100),
    CONSTRAINT PK_G_BIND UNIQUE (BIND_ID, BIND_METHOD, BEAN_ID)
);
COMMENT ON TABLE  _G_BIND                     IS 'BIND';
COMMENT ON COLUMN _G_BIND.BIND_ID             IS 'BIND ID';
COMMENT ON COLUMN _G_BIND.BIND_METHOD         IS 'BIND METHOD';
COMMENT ON COLUMN _G_BIND.BIND_NAME           IS 'BIND 명';
COMMENT ON COLUMN _G_BIND.BEAN_ID             IS 'BEAN ID';
COMMENT ON COLUMN _G_BIND.RESPONSE_VIEW_URI   IS '응답 뷰 URI';
COMMENT ON COLUMN _G_BIND.RESPONSE_LAYOUT_URI IS '응답 레이아웃 URI';


DROP TABLE IF EXISTS _G_MENU;
CREATE TABLE _G_MENU (
    MENU_ID       VARCHAR(20) NOT NULL,
    MENU_NAME     VARCHAR(50) NOT NULL,
    BIND_ID       VARCHAR(50),
    BIND_METHOD   VARCHAR(10),
    UPPER_MENU_ID VARCHAR(20),
    MENU_LEVEL    INT         NOT NULL,
    MENU_SEQUENCE INT         NOT NULL,
    DISPLAY_YN    VARCHAR(1)  NOT NULL,
    CONSTRAINT PK_G_MENU UNIQUE (MENU_ID)
);
COMMENT ON TABLE  _G_MENU               IS '메뉴';
COMMENT ON COLUMN _G_MENU.MENU_ID       IS '메뉴 ID';
COMMENT ON COLUMN _G_MENU.MENU_NAME     IS '메뉴 명';
COMMENT ON COLUMN _G_MENU.BIND_ID       IS 'BIND ID';
COMMENT ON COLUMN _G_MENU.BIND_METHOD   IS 'BIND METHOD';
COMMENT ON COLUMN _G_MENU.UPPER_MENU_ID IS '상위 메뉴 ID';
COMMENT ON COLUMN _G_MENU.MENU_LEVEL    IS '메뉴 레벨';
COMMENT ON COLUMN _G_MENU.MENU_SEQUENCE IS '메뉴 순서';
COMMENT ON COLUMN _G_MENU.DISPLAY_YN    IS '표시 여부';


DROP TABLE IF EXISTS _G_MESSAGE;
CREATE TABLE _G_MESSAGE (
    MESSAGE_CODE     VARCHAR(20)   NOT NULL,
    MESSAGE_TYPE     VARCHAR(2)    NOT NULL,
    LANGUAGE_CODE    VARCHAR(2)    NOT NULL,
    COUNTRY_CODE     VARCHAR(2)    NOT NULL,
    MESSAGE_CONTENT  VARCHAR(2000) NOT NULL,
    CONSTRAINT PK_G_MESSAGE UNIQUE (MESSAGE_CODE, LANGUAGE_CODE, COUNTRY_CODE)
);
COMMENT ON TABLE  _G_MESSAGE                 IS '메시지';
COMMENT ON COLUMN _G_MESSAGE.MESSAGE_CODE    IS '메시지코드';
COMMENT ON COLUMN _G_MESSAGE.MESSAGE_TYPE    IS '메시지유형';
COMMENT ON COLUMN _G_MESSAGE.LANGUAGE_CODE   IS '언어코드';
COMMENT ON COLUMN _G_MESSAGE.COUNTRY_CODE    IS '국가코드';
COMMENT ON COLUMN _G_MESSAGE.MESSAGE_CONTENT IS '메시지내용';


DROP TABLE IF EXISTS _G_PROPERTY;
CREATE TABLE _G_PROPERTY (
    PROPERTY_KEY         VARCHAR(20)   NOT NULL,
    PROPERTY_VALUE       VARCHAR(2000) NOT NULL,
    PROPERTY_DESCRIPTION VARCHAR(2000),
    CONSTRAINT PK_G_PROPERTY UNIQUE (PROPERTY_KEY)
);
COMMENT ON TABLE  _G_PROPERTY                      IS '프로퍼티';
COMMENT ON COLUMN _G_PROPERTY.PROPERTY_KEY         IS '프로퍼티키';
COMMENT ON COLUMN _G_PROPERTY.PROPERTY_VALUE       IS '프로퍼티값';
COMMENT ON COLUMN _G_PROPERTY.PROPERTY_DESCRIPTION IS '프로퍼티설명';


DROP TABLE IF EXISTS _G_TEST;
CREATE TABLE _G_TEST (
    TEST1  VARCHAR(50)  NOT NULL,
    TEST2  VARCHAR(50)  NOT NULL,
    CONSTRAINT PK_G_TEST UNIQUE (TEST1)
);
COMMENT ON TABLE  _G_TEST           IS '테스트';
COMMENT ON COLUMN _G_TEST.TEST1     IS '테스트1';
COMMENT ON COLUMN _G_TEST.TEST2     IS '테스트2';
