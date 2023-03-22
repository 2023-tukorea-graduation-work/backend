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

-- mento.program_parti_tb definition

CREATE TABLE `program_parti_tb` (
    `program_parti_no` int NOT NULL AUTO_INCREMENT COMMENT '프로그램 참여 번호',
    `program_no` int NOT NULL COMMENT '프로그램 번호',
    `mentee_no` int NOT NULL COMMENT '멘티번호',
    `reg_dt` datetime NOT NULL COMMENT '등록일시',
    `mod_dt` datetime NOT NULL COMMENT '수정일시',
    PRIMARY KEY (`program_parti_no`),
    KEY `program_parti_tb_FK` (`program_no`),
    KEY `program_parti_tb_FK_1` (`mentee_no`),
    CONSTRAINT `program_parti_tb_FK` FOREIGN KEY (`program_no`) REFERENCES `program_tb` (`program_no`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `program_parti_tb_FK_1` FOREIGN KEY (`mentee_no`) REFERENCES `mentee_tb` (`mentee_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- mento.attendance_tb definition

CREATE TABLE `attendance_tb` (
     `attend_no` int NOT NULL AUTO_INCREMENT COMMENT '출석번호',
     `program_week_no` int NOT NULL COMMENT '프로그램주차번호',
     `mento_no` int NOT NULL COMMENT '멘토번호',
     `mentee_no` int NOT NULL COMMENT '멘티번호',
     `attend_st` varchar(10) NOT NULL COMMENT '출석상태',
     `attend_date` date NOT NULL COMMENT '출석일자',
     `reg_dt` datetime NOT NULL COMMENT '등록일시',
     `mod_dt` datetime NOT NULL COMMENT '수정일시',
     PRIMARY KEY (`attend_no`),
     KEY `attendance_tb_FK` (`program_week_no`),
     KEY `attendance_tb_FK_1` (`mento_no`),
     KEY `attendance_tb_FK_2` (`mentee_no`),
     CONSTRAINT `attendance_tb_FK` FOREIGN KEY (`program_week_no`) REFERENCES `program_week_tb` (`program_week_no`) ON DELETE CASCADE ON UPDATE CASCADE,
     CONSTRAINT `attendance_tb_FK_1` FOREIGN KEY (`mento_no`) REFERENCES `mento_tb` (`mento_no`) ON DELETE CASCADE ON UPDATE CASCADE,
     CONSTRAINT `attendance_tb_FK_2` FOREIGN KEY (`mentee_no`) REFERENCES `mentee_tb` (`mentee_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='출석';

-- mento.schedule_tb definition

CREATE TABLE `schedule_tb` (
   `schedule_no` int NOT NULL AUTO_INCREMENT COMMENT '일정번호',
   `program_week_no` int DEFAULT NULL COMMENT '프로그램 주차 번호',
   `mentee_no` int DEFAULT NULL COMMENT '멘티번호',
   `mento_no` int DEFAULT NULL COMMENT '멘토번호',
   `user_gb` varchar(20) NOT NULL COMMENT '회원 구분',
   `schedule_gb` varchar(20) NOT NULL COMMENT '일정 구분',
   `content` varchar(100) NOT NULL COMMENT '일정 내용',
   `schedule_start_datetime` datetime NOT NULL COMMENT '일정 시작 일시',
   `schedule_finish_datetime` datetime NOT NULL COMMENT '일정 종료 일시',
   `reg_dt` datetime NOT NULL COMMENT '등록일시',
   `mod_dt` datetime NOT NULL COMMENT '수정일시',
   PRIMARY KEY (`schedule_no`),
   KEY `schedule_tb_FK` (`program_week_no`),
   KEY `schedule_tb_FK_1` (`mento_no`),
   KEY `schedule_tb_FK_2` (`mentee_no`),
   CONSTRAINT `schedule_tb_FK` FOREIGN KEY (`program_week_no`) REFERENCES `program_week_tb` (`program_week_no`) ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT `schedule_tb_FK_1` FOREIGN KEY (`mento_no`) REFERENCES `mento_tb` (`mento_no`) ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT `schedule_tb_FK_2` FOREIGN KEY (`mentee_no`) REFERENCES `mentee_tb` (`mentee_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='일정';