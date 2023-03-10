-- mento.mento_tb definition

CREATE TABLE `mento_tb` (
    `mento_no` int NOT NULL AUTO_INCREMENT COMMENT '멘토번호',
    `name` varchar(100) NOT NULL COMMENT '멘토이름',
    `email` varchar(100) NOT NULL COMMENT '이메일',
    `password` varchar(300) NOT NULL COMMENT '비밀번호',
    `birth_year` int NOT NULL COMMENT '출생년도',
    `college` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '출신학교',
    `major` varchar(100) NOT NULL COMMENT '전공',
    `grade` int NOT NULL COMMENT '학년',
    `act_place` varchar(100) NOT NULL COMMENT '활동 장소',
    `introduction` varchar(300) NOT NULL COMMENT '소개글',
    `img_url` varchar(300) NOT NULL COMMENT '프로필 이미지 URL',
    `reg_dt` datetime NOT NULL COMMENT '등록일시',
    `mod_dt` datetime NOT NULL COMMENT '수정일시',
    PRIMARY KEY (`mento_no`)ㅁ
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- mento.mentee_tb definition

CREATE TABLE `mentee_tb` (
    `mentee_no` int NOT NULL AUTO_INCREMENT COMMENT '멘티번호',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '멘티이름',
    `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '이메일',
    `password` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '비밀번호',
    `birth_year` int NOT NULL COMMENT '출생년도',
    `school` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '출신학교',
    `grade` int NOT NULL COMMENT '학년',
    `act_place` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '활동 장소',
    `introduction` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '소개글',
    `img_url` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '프로필 이미지 URL',
    `reg_dt` datetime NOT NULL COMMENT '등록일시',
    `mod_dt` datetime NOT NULL COMMENT '수정일시',
    PRIMARY KEY (`mentee_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- mento.mentee_tb definition

-- mento.program_tb definition

CREATE TABLE `program_tb` (
      `program_no` int NOT NULL AUTO_INCREMENT COMMENT '프로그램번호',
      `mento_no` int NOT NULL COMMENT '멘토번호',
      `mentee_no` int NOT NULL COMMENT '멘티번호',
      `subject` varchar(100) NOT NULL COMMENT '주제',
      `detail` varchar(100) NOT NULL COMMENT '상세정보',
      `pro_start_date` date NOT NULL COMMENT '프로그램시작일자',
      `pro_finish_date` date NOT NULL COMMENT '프로그램종료일자',
      `recruit_start_date` date NOT NULL COMMENT '모집시작기간',
      `recruit_finish_date` date NOT NULL COMMENT '모집종료일자',
      `capacity` int NOT NULL COMMENT '모집인원',
      `pro_place` varchar(100) NOT NULL COMMENT '활동장소',
      `reg_dt` datetime NOT NULL COMMENT '등록일시',
      `mod_dt` datetime NOT NULL COMMENT '수정일시',
      PRIMARY KEY (`program_no`),
      KEY `program_tb_FK` (`mentee_no`),
      KEY `program_tb_FK_1` (`mento_no`),
      CONSTRAINT `program_tb_FK` FOREIGN KEY (`mentee_no`) REFERENCES `mentee_tb` (`mentee_no`) ON DELETE CASCADE ON UPDATE CASCADE,
      CONSTRAINT `program_tb_FK_1` FOREIGN KEY (`mento_no`) REFERENCES `mento_tb` (`mento_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='프로그램';


-- mento.program_week_tb definition

CREATE TABLE `program_week_tb` (
   `program_week_no` int NOT NULL AUTO_INCREMENT COMMENT '프로그램 주차 번호',
   `program_no` int NOT NULL COMMENT '프로그램 번호',
   `detail` varchar(500) NOT NULL COMMENT '상세정보',
   `reg_dt` datetime NOT NULL COMMENT '등록일시',
   `mod_dt` datetime NOT NULL COMMENT '수정일시',
   PRIMARY KEY (`program_week_no`),
   KEY `program_week_tb_FK` (`program_no`),
   CONSTRAINT `program_week_tb_FK` FOREIGN KEY (`program_no`) REFERENCES `program_tb` (`program_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='프로그램 주차';