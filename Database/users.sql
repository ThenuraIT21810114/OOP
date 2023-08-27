-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2023 at 12:39 PM
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
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`) VALUES
(1, 'thenura', 'Tnw234nem#@', 'thenura123nemhan@gmail.com', '0783956939'),
(2, 'Dasini', 'Tnw23#@', 'it21810114@my.sliit.lk.', '0774070738'),
(3, 'Enter Username...', 'Enter Password...', 'Enter email address..', 'Enter mobile number'),
(4, 'Thenura23', 'Tnw234nem#@', 'thenura123nemhan@gmail.com', '0783956939'),
(5, 'Binura', 'Tnw234nem#@', 'thenura123nemhan@gmail.com', '07839563939'),
(6, 'Thenura Nemhan', 'Tnw234nem#@', 'thenura123nemhan@gmail.com', '0783956939'),
(7, 'Hansani', 'Tnw234nem#@', 'thenura123nemhan@gmail.com', '0774070738'),
(8, 'Sandun', 'Tnw234nem#@', 'thenura123nemhan@gmail.com', '0774070738'),
(9, 'hansi bandara', 'Dinuka@28', 'hansib@gmail.com', '242334633'),
(10, 'Kamal', 'KamalP', 'kamalP123@gmail.com', '0775406034'),
(11, 'Gimhan', 'Abeyrathna', 'gimhana456@gmail.com', '0779339582');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
