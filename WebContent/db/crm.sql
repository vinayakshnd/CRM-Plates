-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2014 at 02:38 PM
-- Server version: 5.5.39
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `crm`
--

-- --------------------------------------------------------

--
-- Table structure for table `agency_info`
--

CREATE TABLE IF NOT EXISTS `agency_info` (
`Office_Id` int(11) NOT NULL,
  `Office_Name` varchar(20) NOT NULL,
  `Office_Add` varchar(40) NOT NULL,
  `Office_Phn` varchar(15) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `agency_info`
--

INSERT INTO `agency_info` (`Office_Id`, `Office_Name`, `Office_Add`, `Office_Phn`) VALUES
(1, 'abc', 'adw', '5454545454'),
(2, 'fc', 'fc', '1233211234'),
(3, 'xyz', 'dfg', '1234567890'),
(4, 'xyz', 'dfg', '1234567890'),
(5, 'xyz', 'jj', '1234567890'),
(6, 'dsfg', 'sfdg', '1234567890'),
(7, 'das', 'daf', '1234567890'),
(8, 'sdf', 'adsf', '1234567890');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
`client_id` int(11) NOT NULL,
  `client_name` varchar(20) NOT NULL,
  `client_address` varchar(30) NOT NULL,
  `client_phn` varchar(10) NOT NULL,
  `client_site_add` varchar(30) NOT NULL,
  `guaranter_name` varchar(20) NOT NULL,
  `guaranter_phn` varchar(10) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2147483647 ;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`client_id`, `client_name`, `client_address`, `client_phn`, `client_site_add`, `guaranter_name`, `guaranter_phn`) VALUES
(1, 'Vina', 'pune1234', '9850070000', 'mum', 'shind', '1234567890'),
(2, 'yur', 'tilak', '1234567899', 'sb1212', 'raj', '0909090909'),
(2147483647, 'zvcx', 'zcxv', '1234567890', 'fdsg', 'cg', '1234567890');

-- --------------------------------------------------------

--
-- Table structure for table `plate_info`
--

CREATE TABLE IF NOT EXISTS `plate_info` (
`Plate_Id` int(11) NOT NULL,
  `Size` varchar(10) NOT NULL,
  `Total` int(11) NOT NULL,
  `Available` int(11) NOT NULL,
  `RatePerPlate` float NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `plate_info`
--

INSERT INTO `plate_info` (`Plate_Id`, `Size`, `Total`, `Available`, `RatePerPlate`) VALUES
(1, '21*3', 21, 21, 1.4),
(2, '9*3', 100, 90, 1.2),
(3, '9*6', 123, 123, 2),
(4, '12*3', 100, 60, 1),
(5, '1', 2, 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `provider`
--

CREATE TABLE IF NOT EXISTS `provider` (
`Provider_Id` int(11) NOT NULL,
  `Provider_Name` varchar(20) NOT NULL,
  `Provider_Phn` varchar(10) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `provider`
--

INSERT INTO `provider` (`Provider_Id`, `Provider_Name`, `Provider_Phn`) VALUES
(1, 'shashi', '12345'),
(2, 'abhijit', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `sub_transaction`
--

CREATE TABLE IF NOT EXISTS `sub_transaction` (
`content_id` int(20) NOT NULL,
  `plate_id` int(10) NOT NULL,
  `rate` float NOT NULL,
  `quantity` float NOT NULL,
  `transaction_id` int(20) NOT NULL,
  `cost` float NOT NULL,
  `prevalloc` int(11) NOT NULL,
  `newalloc` int(11) NOT NULL,
  `submitted` int(11) NOT NULL,
  `provider_id` int(10) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Dumping data for table `sub_transaction`
--

INSERT INTO `sub_transaction` (`content_id`, `plate_id`, `rate`, `quantity`, `transaction_id`, `cost`, `prevalloc`, `newalloc`, `submitted`, `provider_id`) VALUES
(1, 1, 1.4, 1, 1, 1.4, 0, 1, 0, 1),
(2, 2, 1.2, 0, 1, 0, 0, 0, 0, 1),
(3, 3, 2, 1, 1, 2, 0, 1, 0, 1),
(4, 4, 1, 0, 1, 0, 0, 0, 0, 1),
(5, 1, 1.4, 2, 1, 2.8, 0, 2, 0, 2),
(6, 2, 1.2, 0, 1, 0, 0, 0, 0, 2),
(7, 3, 2, 0, 1, 0, 0, 0, 0, 2),
(8, 4, 1, 2, 1, 2, 0, 2, 0, 2),
(9, 1, 1.4, 0, 2, 0, 0, 0, 0, 1),
(10, 2, 1.2, 1, 2, 1.2, 0, 1, 0, 1),
(11, 3, 2, 0, 2, 0, 0, 0, 0, 1),
(12, 4, 1, 0, 2, 0, 0, 0, 0, 1),
(13, 1, 1.4, 0, 3, 0, 0, 0, 0, 1),
(14, 2, 1.2, 1, 3, 1.2, 0, 1, 0, 1),
(15, 3, 2, 0, 3, 0, 0, 0, 0, 1),
(16, 4, 1, 0, 3, 0, 0, 0, 0, 1),
(17, 1, 1.4, 11, 4, 15.4, 0, 11, 0, 1),
(18, 2, 1.2, 0, 4, 0, 0, 0, 0, 1),
(19, 3, 2, 0, 4, 0, 0, 0, 0, 1),
(20, 4, 1, 0, 4, 0, 0, 0, 0, 1),
(21, 1, 1.4, 0, 5, 0, 0, 0, 0, 1),
(22, 2, 1.2, 0, 5, 0, 0, 0, 0, 1),
(23, 3, 2, 0, 5, 0, 0, 0, 0, 1),
(24, 4, 1, 0, 5, 0, 0, 0, 0, 1),
(25, 1, 1.4, 1221, 6, 1709.4, 0, 1221, 0, 1),
(26, 2, 1.2, 0, 6, 0, 0, 0, 0, 1),
(27, 3, 2, 0, 6, 0, 0, 0, 0, 1),
(28, 4, 1, 0, 6, 0, 0, 0, 0, 1),
(29, 1, 1.4, 0, 7, 0, 0, 0, 0, 1),
(30, 2, 1.2, 0, 7, 0, 0, 0, 0, 1),
(31, 3, 2, 0, 7, 0, 0, 0, 0, 1),
(32, 4, 1, 0, 7, 0, 0, 0, 0, 1),
(33, 5, 4, 0, 7, 0, 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
`transaction_id` int(11) NOT NULL,
  `opening_date` date NOT NULL,
  `closing_date` date NOT NULL,
  `advance_amount` float NOT NULL,
  `subadmin_id` varchar(10) NOT NULL,
  `total_amount` float NOT NULL,
  `client_id` varchar(20) NOT NULL,
  `open` int(11) NOT NULL,
  `remaining_amount` float NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `opening_date`, `closing_date`, `advance_amount`, `subadmin_id`, `total_amount`, `client_id`, `open`, `remaining_amount`) VALUES
(7, '2015-01-11', '2015-02-11', 500, '12', 1000, '2', 1, 500);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`id` int(11) NOT NULL,
  `User` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Key` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE IF NOT EXISTS `userinfo` (
`id` int(11) NOT NULL,
  `User_Name` varchar(20) NOT NULL,
  `User_Add` varchar(40) NOT NULL,
  `User_Phn` varchar(15) NOT NULL,
  `Office_Id` varchar(10) NOT NULL,
  `Delete_Status` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`id`, `User_Name`, `User_Add`, `User_Phn`, `Office_Id`, `Delete_Status`) VALUES
(1, 'satish', 'pune', '12341234', 'pp1', 0),
(2, 'ulka', 'pune', '2121210021', 'pp1', 0),
(3, 'vinayak', 'mumbiat', '1245324524', 'tilak', 0),
(4, 'abb', 'bb', '1111222211', 'pp1', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agency_info`
--
ALTER TABLE `agency_info`
 ADD PRIMARY KEY (`Office_Id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
 ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `plate_info`
--
ALTER TABLE `plate_info`
 ADD PRIMARY KEY (`Plate_Id`);

--
-- Indexes for table `provider`
--
ALTER TABLE `provider`
 ADD PRIMARY KEY (`Provider_Id`);

--
-- Indexes for table `sub_transaction`
--
ALTER TABLE `sub_transaction`
 ADD PRIMARY KEY (`content_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
 ADD PRIMARY KEY (`transaction_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agency_info`
--
ALTER TABLE `agency_info`
MODIFY `Office_Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2147483647;
--
-- AUTO_INCREMENT for table `plate_info`
--
ALTER TABLE `plate_info`
MODIFY `Plate_Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `provider`
--
ALTER TABLE `provider`
MODIFY `Provider_Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `sub_transaction`
--
ALTER TABLE `sub_transaction`
MODIFY `content_id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `userinfo`
--
ALTER TABLE `userinfo`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
