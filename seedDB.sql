CREATE DATABASE IF NOT EXISTS student_assessment;

USE student_assessment;

CREATE TABLE users (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50),
role VARCHAR(50),
password VARCHAR(255),
PRIMARY KEY(id)
);

CREATE TABLE courses (
id INT NOT NULL AUTO_INCREMENT,
course_code VARCHAR(10),
name VARCHAR(50),
instructor_id INT,
semester INT,
assessment_id INT,
FOREIGN KEY(instructor_id) REFERENCES users(id),
PRIMARY KEY(id)
);

CREATE TABLE assessment_criteria (
id INT NOT NULL AUTO_INCREMENT,
course_id INT,
quiz1 INT,
quiz2 INT,
quiz3 INT,
quiz4 INT,
quiz5 INT,
assignment1 INT,
assignment2 INT,
assignment3 INT,
midterm INT,
final INT,
FOREIGN KEY(course_id) REFERENCES courses(id),
PRIMARY KEY(id)
);

CREATE TABLE student_courses (
id INT NOT NULL AUTO_INCREMENT,
student_id INT,
course_id INT,
FOREIGN KEY(student_id) REFERENCES users(id),
FOREIGN KEY(course_id) REFERENCES courses(id),
PRIMARY KEY(id)
);

CREATE TABLE student_assessments (
id INT NOT NULL AUTO_INCREMENT,
student_id INT,
course_id INT,
quiz1 INT,
quiz2 INT,
quiz3 INT,
quiz4 INT,
quiz5 INT,
assignment1 INT,
assignment2 INT,
assignment3 INT,
midterm INT,
final INT,
FOREIGN KEY(course_id) REFERENCES courses(id),
PRIMARY KEY (id)
);

-- All example passwords are hashed "password123"
INSERT INTO users (name, role, password) VALUES
('Diane Lane', 'admin', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e'),
('Brenda Lee', 'admin', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e'),
('Dr Amy Sedaris', 'instructor', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e'),
('Dr Neil Jackson', 'instructor', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e'),
('Dr Amina Begum', 'instructor', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e'),
('Brian O Neill', 'student', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e'),
('Louise McSharry', 'student', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e'),
('Connor O Reilly', 'student', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e'),
('Wu Zeitan', 'student', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e'),
('Mona Eltahawy', 'student', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e'),
('Victor Campos', 'student', '4c2874e5a00707042e27e9ca9ac9c017407bbea9bdae1a7984bad4ff7b0ffe31b58f7ca4201c9683738a7fd56cab7d38810776e90554ed2634cb3b84941a962e');

INSERT INTO courses (course_code, name, instructor_id, semester) VALUES 
('CS50', 'Introduction to Programming', 3, 1),
('CS75', 'Databases', 4, 1),
('CS61', 'Computer Architecture', 5, 1),
('CS42', 'Algorithms and Data Structures', 3, 2),
('CS71', 'Web Development', 4, 2),
('CS69', 'Cloud Computing', 5, 2);

INSERT INTO assessment_criteria (course_id, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, final) VALUES
(1, 6, 4, 0, 0, 0, 5, 5, 0, 30, 50),
(2, 2, 2, 2, 2, 2, 2, 4, 4, 30, 50),
(3, 2, 4, 4, 0, 0, 10, 0, 0, 30, 50);

UPDATE courses SET assessment_id = 1 WHERE courses.id = 1;
UPDATE courses SET assessment_id = 2 WHERE courses.id = 2;
UPDATE courses SET assessment_id = 3 WHERE courses.id = 3;

INSERT INTO student_courses (student_id, course_id) VALUES 
(6,1),
(7,1),
(8,1),
(9,1),
(10,1),
(11,1),
(6,2),
(7,2),
(8,2),
(9,2),
(10,2),
(11,2),
(6,3),
(7,3),
(8,3),
(9,3),
(10,3),
(11,3);

INSERT INTO student_assessments (student_id, course_id, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, final) VALUES 
(6,1,6,4,0,0,0,5,5,0,0,0),
(7,1,6,4,0,0,0,5,5,0,0,0),
(8,1,6,4,0,0,0,5,5,0,0,0),
(9,1,6,4,0,0,0,5,5,0,0,0),
(10,1,6,4,0,0,0,5,5,0,0,0),
(11,1,6,4,0,0,0,5,5,0,0,0),
(6,2,2,2,2,2,2,2,4,4,0,0),
(7,2,2,2,2,2,2,2,4,4,0,0),
(8,2,2,2,2,2,2,2,4,4,0,0),
(9,2,2,2,2,2,2,2,4,4,0,0),
(10,2,2,2,2,2,2,2,4,4,0,0),
(11,2,2,2,2,2,2,2,4,4,0,0),
(6,3,2,4,4,0,0,10,0,0,0,0),
(7,3,2,4,4,0,0,10,0,0,0,0),
(8,3,2,4,4,0,0,10,0,0,0,0),
(9,3,2,4,4,0,0,10,0,0,0,0),
(10,3,2,4,4,0,0,10,0,0,0,0),
(11,3,2,4,4,0,0,10,0,0,0,0);