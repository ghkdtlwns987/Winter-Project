SELECT * FROM TB_USER;
DROP TABLE TB_USER;
CREATE TABLE `TB_USER` (
        `NO` int(11) NOT NULL AUTO_INCREMENT,
        `ID` varchar(255) NOT NULL,
        `PW` varchar(256) DEFAULT NULL,
        `NAME` varchar(255) NOT NULL,
        `AUTH` varchar(255) NOT NULL,
        `APPEND_DATE` datetime DEFAULT NULL,
        `UPDATE_DATE` datetime DEFAULT NULL,
        PRIMARY KEY (`NO`)
)AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SELECT * FROM link_users;

DROP TABLE IF EXISTS link_data CASCADE;
DROP TABLE IF EXISTS link_mid CASCADE;
DROP TABLE IF EXISTS link_big CASCADE;
DROP TABLE IF EXISTS board CASCADE;
DROP TABLE IF EXISTS link_users CASCADE;


CREATE TABLE link_users
(
    `ID`           VARCHAR(25)     NOT NULL,
    `PW`           VARCHAR(256)    NOT NULL,
    `Name`         VARCHAR(255)    NOT NULL,
    `Auth`         VARCHAR(255)    NOT NULL,
    `Append_DATE`  DATETIME        NOT NULL,
    `UPDATE_DATE`  DATETIME        NOT NULL,
    PRIMARY KEY (ID)
);

ALTER TABLE link_users COMMENT '회원 정보';


CREATE TABLE link_big
(
    `big_idx`  INT             NOT NULL    AUTO_INCREMENT COMMENT '대분류 인덱스',
    `title`    VARCHAR(100)    NOT NULL    COMMENT '제목',
    `intro`    VARCHAR(300)    NULL        COMMENT '설명',
    `emoji`    VARCHAR(45)     NULL        COMMENT '이모티콘',
    `ID`       VARCHAR(25)     NOT NULL    COMMENT '아이디',
    PRIMARY KEY (big_idx)
);

ALTER TABLE link_big COMMENT '대분류';

ALTER TABLE link_big
    ADD CONSTRAINT FK_link_big_ID_link_users_ID FOREIGN KEY (ID)
        REFERENCES link_users (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE link_mid
(
    `big_idx`   INT             NOT NULL    COMMENT '대분류 인덱스',
    `mid_name`  VARCHAR(100)    NULL        COMMENT '카테고리',
    `mid_idx`   INT             NOT NULL    AUTO_INCREMENT COMMENT '중분류 인덱스',
    PRIMARY KEY (mid_idx)
);

ALTER TABLE link_mid COMMENT '중분류';

ALTER TABLE link_mid
    ADD CONSTRAINT FK_link_mid_big_idx_link_big_big_idx FOREIGN KEY (big_idx)
        REFERENCES link_big (big_idx) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE board
(
    `board_idx`      INT              NOT NULL    AUTO_INCREMENT,
    `board_title`    VARCHAR(45)      NULL,
    `board_content`  VARCHAR(1000)    NULL,
    `ID`             VARCHAR(25)      NULL,
    PRIMARY KEY (board_idx)
);

ALTER TABLE board
    ADD CONSTRAINT FK_board_ID_link_users_ID FOREIGN KEY (ID)
        REFERENCES link_users (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE link_data
(
    `mid_idx`     INT             NOT NULL    COMMENT '중분류 인덱스',
    `data_idx`    INT             NOT NULL    AUTO_INCREMENT COMMENT '데이터 인덱스',
    `data_title`  VARCHAR(500)    NOT NULL    COMMENT '데이터 제목',
    `data_intro`  VARCHAR(500)    NULL        COMMENT '데이터 설명',
    `data_link`   VARCHAR(500)    NOT NULL    COMMENT '데이터 링크',
    PRIMARY KEY (data_idx)
);

ALTER TABLE link_data COMMENT '링크 데이터';

ALTER TABLE link_data
    ADD CONSTRAINT FK_link_data_mid_idx_link_mid_mid_idx FOREIGN KEY (mid_idx)
        REFERENCES link_mid (mid_idx) ON DELETE RESTRICT ON UPDATE RESTRICT;

