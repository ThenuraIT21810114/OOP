-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2023 at 12:38 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `issue_book_details`
--

CREATE TABLE `issue_book_details` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(150) DEFAULT NULL,
  `student_id` varchar(11) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `issue_book_details`
--

INSERT INTO `issue_book_details` (`id`, `book_id`, `book_name`, `student_id`, `student_name`, `issue_date`, `due_date`, `status`) VALUES
(1, 1, 'JAVA Programming', 'IT21865678', 'Kelum Senanayake', '2023-05-19', '2023-05-23', 'returned'),
(2, 1, '', 'IT21865678', 'Kelum Senanayake', '2023-05-19', '2023-05-23', 'returned'),
(9, 2, 'MySQL Database Management', 'IT21345516', 'Hansani Bandara', '2023-05-01', '2023-05-04', 'pending'),
(10, 2, 'MySQL Database Management', 'IT21810114', 'Thenura Nemhan', '2023-05-01', '2023-05-05', 'Pending'),
(11, 5, 'Othello', 'IT8567432', 'Sandun Perera', '2023-05-02', '2023-05-06', 'returned');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
