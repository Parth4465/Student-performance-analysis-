-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 24, 2024 at 11:15 AM
-- Server version: 5.5.39
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `student_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance_tbl`
--

CREATE TABLE IF NOT EXISTS `attendance_tbl` (
  `id` int(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rollno` varchar(50) NOT NULL,
  `year` varchar(100) NOT NULL,
  `branch` varchar(100) NOT NULL,
  `status` varchar(50) NOT NULL,
  `date` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance_tbl`
--

INSERT INTO `attendance_tbl` (`id`, `name`, `rollno`, `year`, `branch`, `status`, `date`) VALUES
(1, 'Priya', '12', 'I', 'CSE', 'Absent', '2023-11-27'),
(2, 'Hemant', '32', 'II', 'E&TC', 'Present', '2023-11-27'),
(3, 'swati', '10', '2', 'CSE', '1', '2023-12-16'),
(4, 'Swamini', '2', '2', 'cse', '0', '2023-12-16'),
(1, 'Priya', '12', 'I', 'CSE', '1', '2023-12-16'),
(2, 'Naveen', '32', 'II', 'E&TC', '0', '2023-12-16');

-- --------------------------------------------------------

--
-- Table structure for table `dept_tbl`
--

CREATE TABLE IF NOT EXISTS `dept_tbl` (
`id` int(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `department` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `dept_tbl`
--

INSERT INTO `dept_tbl` (`id`, `name`, `email`, `contact`, `department`, `password`) VALUES
(1, 'Piyush Pakhale', 'hodit@gmail.com', '7845124578', 'IT', '123456'),
(2, 'Pranav Gokhale', 'hodcse@gmail.com', '9365896325', 'CSE', '123456'),
(3, 'Ashwini Patil', 'hodmech@gmail.com', '9854785698', 'Mech.', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `feedback_tbl`
--

CREATE TABLE IF NOT EXISTS `feedback_tbl` (
`id` int(20) NOT NULL,
  `description` varchar(500) NOT NULL,
  `rollno` varchar(50) NOT NULL,
  `year` varchar(50) NOT NULL,
  `brach` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `feedback_tbl`
--

INSERT INTO `feedback_tbl` (`id`, `description`, `rollno`, `year`, `brach`, `email`) VALUES
(2, '	             hello testing                           \r\n											', '12', 'I', 'CSE', 'priya@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `marks_tbl`
--

CREATE TABLE IF NOT EXISTS `marks_tbl` (
  `id` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rollno` varchar(50) NOT NULL,
  `year` varchar(100) NOT NULL,
  `branch` varchar(50) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `total` varchar(100) NOT NULL,
  `marks` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks_tbl`
--

INSERT INTO `marks_tbl` (`id`, `name`, `rollno`, `year`, `branch`, `subject`, `total`, `marks`, `date`) VALUES
(1, 'Priya', '12', 'I', 'CSE', 'DS', '25', '20', '2023-11-28'),
(2, 'Naveen', '32', 'II', 'E&TC', 'DS', '25', '20', '2023-11-28');

-- --------------------------------------------------------

--
-- Table structure for table `notice_tbl`
--

CREATE TABLE IF NOT EXISTS `notice_tbl` (
`id` int(20) NOT NULL,
  `image` varchar(100) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `notice_tbl`
--

INSERT INTO `notice_tbl` (`id`, `image`, `timestamp`) VALUES
(2, 'notice.jpg', '2023-11-27 09:12:41'),
(3, 'back.jpg', '2024-02-14 11:16:36');

-- --------------------------------------------------------

--
-- Table structure for table `staff_tbl`
--

CREATE TABLE IF NOT EXISTS `staff_tbl` (
`id` int(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `department` varchar(50) NOT NULL,
  `year` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `staff_tbl`
--

INSERT INTO `staff_tbl` (`id`, `name`, `email`, `contact`, `department`, `year`, `password`) VALUES
(1, 'Swati Bairagi', 'swati@gmail.com', '7845124578', 'AI&ML', 'III', '123456'),
(2, 'Kavita Shinde', 'kavita@gmail.com', '9168545258', 'Mech.', 'I', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `student_tbl`
--

CREATE TABLE IF NOT EXISTS `student_tbl` (
`id` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rollno` varchar(100) NOT NULL,
  `mobile` varchar(100) NOT NULL,
  `year` varchar(50) NOT NULL,
  `branch` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `student_tbl`
--

INSERT INTO `student_tbl` (`id`, `name`, `rollno`, `mobile`, `year`, `branch`, `email`, `contact`, `password`, `status`) VALUES
(1, 'Priya', '12', '7845965856', 'I', 'CSE', 'priya@gmail.com', '9658568956', '454545', 'Approved'),
(2, 'Naveen', '32', '7066169806', 'II', 'E&TC', 'hem@gmail.com', '7845124578', '123456', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `timetable_tbl`
--

CREATE TABLE IF NOT EXISTS `timetable_tbl` (
`id` int(20) NOT NULL,
  `image` varchar(200) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `timetable_tbl`
--

INSERT INTO `timetable_tbl` (`id`, `image`, `timestamp`) VALUES
(1, 'timetable.jpg', '2023-11-27 09:08:35');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dept_tbl`
--
ALTER TABLE `dept_tbl`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedback_tbl`
--
ALTER TABLE `feedback_tbl`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notice_tbl`
--
ALTER TABLE `notice_tbl`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff_tbl`
--
ALTER TABLE `staff_tbl`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_tbl`
--
ALTER TABLE `student_tbl`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `timetable_tbl`
--
ALTER TABLE `timetable_tbl`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dept_tbl`
--
ALTER TABLE `dept_tbl`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `feedback_tbl`
--
ALTER TABLE `feedback_tbl`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `notice_tbl`
--
ALTER TABLE `notice_tbl`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `staff_tbl`
--
ALTER TABLE `staff_tbl`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `student_tbl`
--
ALTER TABLE `student_tbl`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `timetable_tbl`
--
ALTER TABLE `timetable_tbl`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
