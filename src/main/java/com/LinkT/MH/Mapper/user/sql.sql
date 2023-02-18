DROP TABLE IF EXISTS link_data CASCADE;
DROP TABLE IF EXISTS link_mid CASCADE;
DROP TABLE IF EXISTS link_big CASCADE;
DROP TABLE IF EXISTS board CASCADE;
DROP TABLE IF EXISTS link_board CASCADE;
DROP TABLE IF EXISTS link_users CASCADE;
DROP TABLE IF EXISTS link_comment CASCADE;
-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- link_users Table Create SQL
-- 테이블 생성 SQL - link_users
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


-- link_board Table Create SQL
-- 테이블 생성 SQL - link_board
CREATE TABLE link_board
(
    `board_idx`      INT              NOT NULL    AUTO_INCREMENT,
    `board_title`    VARCHAR(45)      NULL,
    `board_content`  VARCHAR(1000)    NULL,
    `ID`             VARCHAR(25)      NULL,
    PRIMARY KEY (board_idx)
);

-- Foreign Key 설정 SQL - link_board(ID) -> link_users(ID)
ALTER TABLE link_board
    ADD CONSTRAINT FK_link_board_ID_link_users_ID FOREIGN KEY (ID)
        REFERENCES link_users (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - link_board(ID)
-- ALTER TABLE link_board
-- DROP FOREIGN KEY FK_link_board_ID_link_users_ID;


-- link_comment Table Create SQL
-- 테이블 생성 SQL - link_comment
CREATE TABLE link_comment
(
    `cmt_idx`      INT              NULL        AUTO_INCREMENT,
    `board_idx`    INT              NULL,
    `ID`           VARCHAR(25)      NULL,
    `cmt_content`  VARCHAR(1000)    NOT NULL,
    `Append_DATE`  DATETIME         NOT NULL,
    PRIMARY KEY (cmt_idx)
);

-- Foreign Key 설정 SQL - link_comment(ID) -> link_users(ID)
ALTER TABLE link_comment
    ADD CONSTRAINT FK_link_comment_ID_link_users_ID FOREIGN KEY (ID)
        REFERENCES link_users (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - link_comment(ID)
-- ALTER TABLE link_comment
-- DROP FOREIGN KEY FK_link_comment_ID_link_users_ID;

-- Foreign Key 설정 SQL - link_comment(board_idx) -> link_board(board_idx)
ALTER TABLE link_comment
    ADD CONSTRAINT FK_link_comment_board_idx_link_board_board_idx FOREIGN KEY (board_idx)
        REFERENCES link_board (board_idx) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - link_comment(board_idx)
-- ALTER TABLE link_comment
-- DROP FOREIGN KEY FK_link_comment_board_idx_link_board_board_idx;


