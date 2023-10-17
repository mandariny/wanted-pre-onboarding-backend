-- DB가 없으면 생성
CREATE DATABASE IF NOT EXISTS jobportal;

-- jobportal DB 사용
USE jobportal;

-- 사용할 테이블 생성
CREATE TABLE Company (
    id BIGINT  AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    nation VARCHAR(50) NOT NULL,
    region VARCHAR(50) NOT NULL,
    detail_addr VARCHAR(100) NULL,
    establishment DATETIME NULL
);

CREATE TABLE User (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    prefer_position VARCHAR(50) NOT NULL
);

CREATE TABLE Recruit (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    position VARCHAR(50) NOT NULL,
    reward INT NOT NULL,
    contents VARCHAR(255) NOT NULL,
    skill VARCHAR(50) NOT NULL,
    post_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    company_id BIGINT NOT NULL,
    FOREIGN KEY (company_id) REFERENCES Company(id),
    INDEX (company_id)
);

CREATE TABLE JobApplication (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    recruit_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    apply_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (recruit_id) REFERENCES Recruit(id),
    FOREIGN KEY (user_id) REFERENCES User(id)
);

-- 샘플 데이터 삽입
INSERT INTO Company (name, nation, region, detail_addr, establishment)
VALUES
    ('원티드랩', '한국', '강남', 'ㅇㅇ길 14-3, 2층', '2003-01-01 09:00:00'),
    ('원티드코리아', '한국', '강남', 'ㄱㄱ길 11-2, 5층', '2013-02-01 10:00:00'),
    ('네이버', '한국', '판교', 'ㄴㄴ길 74-2, 3층', '2008-03-01 11:00:00'),
    ('카카오', '한국', '판교', 'ㄷㄷ길 56, 13층', '2010-04-01 12:00:00'),
    ('현대자동차', '한국', '선릉', 'ㄹㄹ길 11-21, 21층', '2011-05-01 13:00:00');

INSERT INTO User (name, email, prefer_position)
VALUES
    ('김철수', 'user1@email.com', '백엔드'),
    ('김영희', 'user2@email.com', '프론트엔드'),
    ('이철수', 'user3@email.com', '데이터사이언티스트'),
    ('이영희', 'user4@email.com', '백엔드'),
    ('박철수', 'user5@email.com', '데이터엔지니어');

INSERT INTO Recruit (position, reward, contents, skill, company_id)
VALUES
    ('백엔드 주니어 개발자', 1000000, '원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..', 'Java', 1),
    ('백엔드 주니어 개발자', 1500000, '원티드코리아에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..', 'Java', 2),
    ('백엔드 시니어 개발자', 2000000, '네이버에서 백엔드 시니어 개발자를 채용합니다. 자격요건은..', 'Spring', 3),
    ('프론트엔드 주니어 개발자', 2500000, '카카오에서 프론트엔드 주니어 개발자를 채용합니다. 자격요건은..', 'Javascript', 4),
    ('프론트엔드 시니어 개발자', 3000000, '현대자동차에서 프론트엔드 시니어 개발자를 채용합니다. 자격요건은..', 'Typescript', 5);

INSERT INTO JobApplication (recruit_id, user_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);
