create table CHAT_MESSAGE (
	MESSAGE_ID    Number 		NOT NULL PRIMARY KEY,
	NICKNAME      VARCHAR2(20)  NOT NULL,
	REGISTER_DATE DATE 			NOT NULL,
	MESSAGE       VARCHAR2(200) NOT NULL
)

CREATE SEQUENCE CHAT_SEQ;