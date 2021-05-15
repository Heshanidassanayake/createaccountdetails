-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 06:35 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetbadget02`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserId` int(50) NOT NULL,
  `UserFirstName` varchar(50) NOT NULL,
  `UserLastName` varchar(50) NOT NULL,
  `UserAddress` varchar(50) NOT NULL,
  `UserNIC` varchar(50) NOT NULL,
  `UserPhoneNumber` varchar(50) NOT NULL,
  `UserEmail` varchar(50) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `UserPassword` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserId`, `UserFirstName`, `UserLastName`, `UserAddress`, `UserNIC`, `UserPhoneNumber`, `UserEmail`, `UserName`, `UserPassword`) VALUES
(1219, 'drdrttddr', 'ftrtttf', 'dtrdtr', 'jhgugyugy', 'gguyu', 'hftruyi', 'igiioii', 'guyguyi'),
(1220, 'drdrttddr', 'ftrtttf', 'dtrdtr', 'jhgugyugy', 'gguyu', 'hftruyi', 'igiioii', 'huhjhj'),
(1221, 'ffhjhbnm', 'kjnkhi kjk', 'hjhjn,', '688979', '878977809', 'hjkhkjhkjkkljl', 'hjuhuhjbkjbkj', 'ghuhu8'),
(1222, 'hjhjbkm', 'ftrtttf', 'bjbjbkjj', 'jhgugyugy', 'nkj klk', 'hftruyi', 'jjkjknjnj', 'kjhiuhuii');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UserId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1223;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
