alter table classrooms
add constraint FK_class_rooms_majorId foreign key (majorId) references `majors` (`majorId`) ON DELETE CASCADE,
add constraint FK_class_rooms_teacherId foreign key (teacherId) references `teachers` (`teacherId`) ON DELETE CASCADE;

alter table courseregistrations
add constraint FK_course_registrations_studentId foreign key (studentId) references `students` (`studentId`) on delete cascade,
add constraint FK_course_registrations_moduleSubjectId foreign key (moduleSubjectId) references `modulesubjects` (`moduleSubjectId`) on delete cascade;

alter table departments
add constraint FK_departments_teacherId foreign key (teacherId) references `teachers` (teacherId) on delete cascade;

alter table majors
add constraint FK_majors_departmentId foreign key (departmentId) references `departments` (`departmentId`) on delete cascade,
add constraint FK_majors_teacherId foreign key (teacherId) references `teachers` (`teacherId`) on delete cascade;

alter table modulesubjects
add constraint FK_module_subjects_subjectId foreign key (subjectId) references `subjects` (`subjectId`) on delete cascade,
add constraint FK_module_subjects_teacherId foreign key (teacherId) references `teachers` (`teacherId`) on delete cascade;

alter table results
add constraint FK_results_courseRegistrationId foreign key (courseRegistrationId) references `courseregistrations` (`courseRegistrationId`) on delete cascade;

alter table students
add constraint FK_students_accountId foreign key (accountId) references `accounts` (`accountId`) on delete cascade,
add constraint FK_students_inforId foreign key (studentId) references `infors` (`inforId`) on delete cascade;

alter table subjects
add constraint FK_subjects_departmentId foreign key (departmentId) references `departments` (`departmentId`) on delete cascade;

alter table teachers
add constraint FK_teachers_accountId foreign key (accountId) references `accounts` (`accountId`) on delete cascade,
add constraint FK_teachers_inforId foreign key (inforId) references `infors` (`inforId`) on delete cascade;

alter table accounts
add constraint FK_accounts_roleId foreign key (roleId) references `roles` (`roleId`) on delete cascade;

insert into roles (roleId,roleName,createdAt,updatedAt) values 
	(1,'admin','2023-09-03 05:23:59', '2023-09-03 09:08:23'),
	(2,'teacher','2023-09-03 05:23:59', '2023-09-03 09:08:23'),
	(3,'student','2023-09-03 05:23:59', '2023-09-03 09:08:23');
INSERT INTO classrooms (classId, className, quantity, majorId, teacherId,createdAt, updatedAt) VALUES
	(1, 'Kĩ thuật phần mềm 4', 70, 1, 2, '2023-09-03 10:32:38', '2023-09-03 11:57:01'),
	(2, 'Kĩ thuật phần mềm 3', 65, 1, 2, '2023-09-03 12:32:46', '2023-09-03 12:38:21'),
	(3, 'Kĩ thuật phần mềm 2', 65, 1, 2, '2023-09-03 12:38:28', '2023-09-03 12:38:28'),
	(4, 'Kĩ thuật phần mềm 1', 65, 1, 2, '2023-09-03 12:38:32', '2023-09-03 12:38:32'),
	(5, 'Quản trị khách sạn 1', 65, 11, 6, '2023-09-04 08:28:07', '2023-09-04 08:28:07');
INSERT INTO departments(departmentId, departmentName,teacherId, createdAt, updatedAt) VALUES
	(1, 'Công nghệ thông tin', 1, '2023-09-03 08:14:29', '2023-09-03 11:34:41'),
	(2, 'Cơ khí', 2, '2023-09-04 05:04:00', '2023-09-04 05:04:00'),
	(3, 'Công nghệ hóa', 2, '2023-09-04 05:04:12', '2023-09-04 05:04:12'),
	(4, 'Công nghệ oto', 2, '2023-09-04 05:04:24', '2023-09-04 05:04:24'),
	(5, 'Điện', 1, '2023-09-04 05:04:32', '2023-09-04 05:04:32'),
	(6, 'Điện tử', 1, '2023-09-04 05:04:37', '2023-09-04 05:04:37'),
	(7, 'Kế toán - kiểm toán', 3, '2023-09-04 05:05:01', '2023-09-04 05:05:01'),
	(8, 'Quản lý kinh doanh', 3, '2023-09-04 05:05:21', '2023-09-04 05:05:21'),
    (9, 'Du lịch', 3, '2023-09-04 05:05:21', '2023-09-04 05:05:21');
insert into accounts (accountId,userName,`password`,roleId,createdAt,updatedAt) values 
	(1, 'admin', 123456, 1, '2023-09-03 05:23:59', '2023-09-03 05:23:59'),
	(2, 'giaovien', '$2a$10$k0GD6khRK0naL1tTxHNu6eG.WYBXPATL5c.p4dEBLPYYaf8rHM0o6', 2, '2023-09-03 05:23:59', '2023-09-03 09:08:23'),
	(3, 'sinhvien', '$2a$10$k0GD6khRK0naL1tTxHNu6eG.WYBXPATL5c.p4dEBLPYYaf8rHM0o6', 3, '2023-09-03 05:23:59', '2023-09-03 11:36:05');
INSERT INTO infors (inforId, fullName, address, phoneNumber, email, dateOfBirth, gender, createdAt, updatedAt) VALUES
	(1, 'Phạm Hồng Nguyên', 'Hà nội', '0372238783', 'phamhongnguyen@Haui', '2002-07-01 ', 1, '2023-09-03 05:23:59', '2023-09-05 02:06:55'),
	(2, 'Trịnh Xuân Sơn', 'Hà nội', '0372238783', 'trinhxuanson@Haui', '2002-07-07 ', 1, '2023-09-03 05:23:59', '2023-09-03 11:36:05'),
	(3, 'Trần Ngọc Mai', 'Hà nội', '0356938783', 'tranngocmai@Haui', '2000-01-07', 0, '2023-09-03 05:23:59', '2023-09-03 09:08:23');
INSERT INTO teachers (teacherId, accountId, inforId, createdAt, updatedAt) VALUES
	(1, 1, 1, '2023-09-03 05:23:59', '2023-09-03 05:23:59'),
	(2, 2, 2, '2023-09-03 05:23:59', '2023-09-03 05:23:59');
INSERT INTO students (studentId, accountId, inforId, classId, gpa, createdAt, updatedAt) VALUES
	(1, 3, 3, 1, 0, '2023-09-03 12:13:14', '2023-09-03 12:13:14');	
    
    
INSERT INTO courseregistrations (courseRegistrationId, studentId, moduleSubjectId, createdAt, updatedAt) VALUES
	(1, 3, 1, '2023-09-04 08:55:08', '2023-09-04 08:55:08'),
	(2, 3, 2, '2023-09-04 09:05:29', '2023-09-04 09:05:29');
INSERT INTO modulesubjects (moduleSubjectId, subjectId, currentStudent, maximumStudent, teacherId, startAt, endAt, createdAt, updatedAt) VALUES
	(1, 1, 1, 60, 1, '2023-09-04 ', '2023-09-10 ', '2023-09-04 06:28:52', '2023-09-07 07:30:16'),
	(2, 2, 1, 60, 2, '2023-09-06 ', '2023-09-10 ', '2023-09-04 06:44:00', '2023-09-05 02:54:05');
INSERT INTO subjects (subjectId, subjectName, credit, departmentId, createdAt, updatedAt) VALUES
	(1, 'Chủ nghĩa xã hội khoa học', 2, 1, '2023-09-03 11:31:02', '2023-09-03 11:31:02'),
	(2, 'Kinh tế chính trị Mác-Lênin', 2, 1, '2023-09-03 11:31:02', '2023-09-03 11:31:02'),
	(3, 'Lịch sử Đảng Cộng sản Việt Nam', 2, 1, '2023-09-03 11:31:02', '2023-09-03 11:31:02'),
	(4, 'Triết học Mác-Lênin', 3, 1, '2023-09-03 11:31:02', '2023-09-03 11:31:02'),
	(5, 'Tư tưởng Hồ Chí Minh', 2, 1, '2023-09-03 11:31:02', '2023-09-03 11:31:02');
    
    
INSERT INTO majors (majorId, majorName, departmentId, teacherId, createdAt, updatedAt) VALUES
	(1, 'Kĩ thuật phần mềm', 1, 1, '2023-09-03 08:14:56', '2023-09-03 08:14:56'),
	(2, 'Hệ thống thông tin', 1, 1, '2023-09-03 09:36:26', '2023-09-03 09:36:35'),
	(4, 'Công nghệ thông tin', 1, 1, '2023-09-04 05:08:52', '2023-09-04 05:08:52'),
	(5, 'Công nghệ kỹ thuật cơ điện tử', 2, 2, '2023-09-04 05:09:14', '2023-09-04 05:09:14'),
	(6, 'Công nghệ kỹ thuật ô tô', 4, 2, '2023-09-04 05:09:23', '2023-09-04 05:09:23'),
	(7, 'Robot và trí tuệ nhân tạo', 1, 2, '2023-09-04 05:09:34', '2023-09-04 05:09:34'),
	(8, 'Công nghệ kỹ thuật điện', 5, 2, '2023-09-04 05:09:45', '2023-09-04 05:09:45'),
	(9, 'Công nghệ kỹ thuật hoá học', 3, 2, '2023-09-04 05:10:04', '2023-09-04 05:10:04'),
	(10, 'Công nghệ kỹ thuật cơ điện tử ô tô', 2, 2, '2023-09-04 05:10:20', '2023-09-04 05:10:20'),
	(11, 'Quản trị khách sạn', 9, 3, '2023-09-04 05:10:32', '2023-09-04 05:10:32'),
	(12, 'Quản trị nhà hàng và dịch vụ ăn uống', 9, 3, '2023-09-04 05:10:40', '2023-09-04 05:10:40'),
	(13, 'Công nghệ kỹ thuật điều khiển và TĐH', 2, 3, '2023-09-04 05:11:00', '2023-09-04 05:11:00');