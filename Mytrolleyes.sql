-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 15-11-2019 a las 00:25:03
-- Versión del servidor: 8.0.17
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `trolleyes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id` int(11) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `factura_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`id`, `cantidad`, `factura_id`, `producto_id`) VALUES
(1, 20, 23, 6),
(2, 48, 17, 17),
(3, 4, 23, 5),
(4, 30, 18, 20),
(5, 42, 11, 20),
(6, 23, 19, 3),
(7, 2, 5, 1),
(8, 11, 8, 15),
(9, 25, 8, 10),
(10, 29, 22, 14),
(11, 23, 17, 17),
(12, 2, 7, 25),
(13, 38, 15, 23),
(14, 43, 8, 11),
(15, 42, 21, 11),
(16, 48, 12, 6),
(17, 3, 20, 6),
(18, 40, 2, 7),
(19, 7, 16, 7),
(20, 48, 11, 4),
(21, 15, 25, 16),
(22, 3, 22, 10),
(23, 9, 22, 7),
(24, 30, 24, 5),
(25, 23, 11, 19),
(26, 28, 3, 21),
(27, 26, 13, 16),
(28, 40, 16, 24),
(29, 1, 13, 4),
(30, 31, 8, 21),
(31, 27, 10, 1),
(32, 47, 13, 25),
(33, 23, 3, 11),
(34, 38, 21, 17),
(35, 1, 20, 7),
(36, 5, 25, 5),
(37, 49, 13, 11),
(38, 15, 8, 18),
(39, 28, 25, 10),
(40, 29, 22, 23),
(41, 18, 19, 25),
(42, 12, 21, 5),
(43, 34, 11, 18),
(44, 4, 3, 9),
(45, 6, 9, 19),
(46, 37, 23, 4),
(47, 22, 13, 5),
(48, 8, 3, 6),
(49, 23, 5, 7),
(50, 49, 13, 10),
(51, 10, 1, 7),
(52, 23, 18, 25),
(53, 16, 9, 18),
(54, 39, 20, 10),
(55, 21, 5, 12),
(56, 2, 4, 15),
(57, 46, 6, 4),
(58, 46, 1, 10),
(59, 27, 12, 1),
(60, 5, 19, 15),
(61, 3, 1, 5),
(62, 29, 6, 18),
(63, 44, 15, 17),
(64, 29, 24, 24),
(65, 15, 12, 10),
(66, 17, 12, 2),
(67, 30, 14, 11),
(68, 3, 6, 21),
(69, 34, 8, 18),
(70, 1, 16, 17),
(71, 41, 22, 9),
(72, 6, 15, 3),
(73, 46, 9, 5),
(74, 5, 1, 5),
(75, 29, 17, 21),
(76, 49, 6, 16),
(77, 22, 1, 1),
(78, 9, 10, 14),
(79, 26, 20, 5),
(80, 15, 4, 2),
(81, 9, 12, 1),
(82, 39, 8, 9),
(83, 26, 3, 19),
(84, 6, 21, 3),
(85, 7, 6, 2),
(86, 2, 8, 23),
(87, 49, 11, 10),
(88, 12, 10, 6),
(89, 15, 22, 9),
(90, 14, 19, 6),
(91, 47, 5, 7),
(92, 9, 12, 6),
(93, 41, 22, 23),
(94, 33, 2, 19),
(95, 19, 9, 25),
(96, 38, 10, 7),
(97, 1, 24, 17),
(98, 49, 7, 5),
(99, 4, 4, 12),
(100, 3, 16, 1),
(101, 10, 3, 19),
(102, 7, 3, 15),
(103, 15, 14, 12),
(104, 32, 6, 18),
(105, 32, 19, 10),
(106, 23, 9, 16),
(107, 47, 8, 10),
(108, 42, 17, 25),
(109, 12, 21, 13),
(110, 24, 4, 19),
(111, 2, 2, 12),
(112, 28, 12, 23),
(113, 42, 14, 15),
(114, 21, 16, 7),
(115, 49, 16, 17),
(116, 5, 18, 18),
(117, 25, 18, 11),
(118, 13, 10, 1),
(119, 36, 4, 3),
(120, 22, 20, 10),
(121, 33, 4, 13),
(122, 1, 24, 24),
(123, 8, 22, 3),
(124, 29, 6, 16),
(125, 2, 15, 17),
(126, 12, 14, 10),
(127, 18, 7, 13),
(128, 49, 22, 8),
(129, 17, 2, 23),
(130, 19, 3, 11),
(131, 7, 17, 6),
(132, 36, 11, 8),
(133, 37, 24, 23),
(134, 33, 24, 13),
(135, 49, 1, 25),
(136, 48, 6, 3),
(137, 47, 20, 15),
(138, 3, 23, 15),
(139, 16, 11, 5),
(140, 12, 6, 14),
(141, 48, 5, 16),
(142, 2, 24, 25),
(143, 16, 5, 2),
(144, 13, 5, 6),
(145, 1, 19, 2),
(146, 38, 7, 3),
(147, 4, 4, 5),
(148, 4, 8, 10),
(149, 11, 5, 25),
(150, 6, 5, 5),
(151, 5, 7, 15),
(152, 45, 16, 3),
(153, 29, 8, 14),
(154, 29, 2, 25),
(155, 45, 18, 14),
(156, 30, 19, 6),
(157, 26, 21, 24),
(158, 40, 3, 25),
(159, 17, 4, 13),
(160, 34, 25, 20),
(161, 21, 14, 18),
(162, 34, 3, 23),
(163, 23, 8, 5),
(164, 12, 6, 16),
(165, 42, 8, 14),
(166, 13, 4, 9),
(167, 36, 9, 19),
(168, 32, 24, 25),
(169, 13, 25, 22),
(170, 43, 16, 19),
(171, 20, 9, 8),
(172, 28, 22, 17),
(173, 28, 15, 22),
(174, 48, 21, 20),
(175, 36, 20, 24),
(176, 11, 8, 19),
(177, 12, 5, 25),
(178, 40, 8, 11),
(179, 29, 21, 16),
(180, 8, 12, 9),
(181, 38, 12, 20),
(182, 43, 14, 20),
(183, 45, 4, 1),
(184, 11, 6, 5),
(185, 10, 9, 2),
(186, 34, 19, 24),
(187, 10, 8, 6),
(188, 48, 5, 8),
(189, 5, 15, 5),
(190, 2, 16, 7),
(191, 41, 4, 15),
(192, 8, 23, 19),
(193, 10, 8, 2),
(194, 30, 3, 15),
(195, 32, 6, 24),
(196, 36, 13, 14),
(197, 16, 24, 1),
(198, 47, 14, 4),
(199, 23, 12, 19),
(200, 35, 8, 3),
(201, 24, 7, 20),
(202, 42, 2, 7),
(203, 20, 23, 1),
(204, 47, 12, 17),
(205, 29, 22, 20),
(206, 35, 20, 4),
(207, 47, 25, 3),
(208, 8, 17, 9),
(209, 44, 10, 10),
(210, 9, 10, 19),
(211, 9, 16, 2),
(212, 21, 2, 25),
(213, 35, 7, 8),
(214, 36, 17, 12),
(215, 47, 10, 11),
(216, 9, 10, 15),
(217, 14, 3, 11),
(218, 20, 24, 2),
(219, 1, 16, 1),
(220, 6, 13, 1),
(221, 7, 9, 13),
(222, 35, 14, 8),
(223, 12, 23, 16),
(224, 17, 2, 21),
(225, 28, 16, 21),
(226, 8, 15, 14),
(227, 9, 25, 13),
(228, 6, 3, 7),
(229, 49, 24, 21),
(230, 38, 8, 23),
(231, 10, 11, 13),
(232, 49, 18, 8),
(233, 21, 24, 11),
(234, 17, 12, 21),
(235, 6, 4, 9),
(236, 49, 1, 20),
(237, 15, 5, 15),
(238, 13, 9, 24),
(239, 11, 13, 4),
(240, 39, 25, 20),
(241, 33, 23, 21),
(242, 6, 1, 14),
(243, 27, 15, 17),
(244, 21, 8, 14),
(245, 41, 24, 3),
(246, 33, 7, 9),
(247, 16, 10, 4),
(248, 35, 17, 5),
(249, 48, 4, 10),
(250, 44, 25, 23),
(251, 30, 10, 1),
(252, 20, 4, 5),
(253, 43, 15, 20),
(254, 15, 7, 14),
(255, 16, 11, 16),
(256, 9, 25, 15),
(257, 20, 13, 11),
(258, 3, 15, 12),
(259, 48, 21, 10),
(260, 6, 8, 23),
(261, 17, 2, 25),
(262, 3, 11, 12),
(263, 30, 21, 9),
(264, 15, 3, 23),
(265, 47, 24, 11),
(266, 13, 25, 2),
(267, 33, 24, 7),
(268, 10, 18, 10),
(269, 10, 9, 20),
(270, 11, 16, 22),
(271, 8, 18, 25),
(272, 31, 13, 17),
(273, 48, 17, 24),
(274, 20, 6, 12),
(275, 19, 15, 20),
(276, 15, 5, 6),
(277, 2, 8, 5),
(278, 8, 20, 14),
(279, 23, 12, 4),
(280, 9, 5, 14),
(281, 13, 11, 18),
(282, 1, 4, 9),
(283, 41, 7, 17),
(284, 42, 23, 1),
(285, 25, 18, 7),
(286, 22, 17, 10),
(287, 24, 17, 7),
(288, 42, 6, 11),
(289, 6, 10, 2),
(290, 3, 21, 15),
(291, 37, 19, 24),
(292, 28, 5, 4),
(293, 33, 10, 21),
(294, 28, 24, 18),
(295, 29, 8, 3),
(296, 11, 9, 2),
(297, 37, 10, 5),
(298, 47, 13, 5),
(299, 2, 7, 20),
(300, 14, 10, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `iva` int(3) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id`, `fecha`, `iva`, `usuario_id`) VALUES
(1, '2018-02-01', 21, 20),
(2, '2018-03-20', 21, 3),
(3, '2018-01-20', 21, 19),
(4, '2015-09-05', 21, 26),
(5, '2018-09-04', 21, 5),
(6, '2019-09-21', 21, 12),
(7, '2016-12-05', 21, 2),
(8, '2015-04-11', 21, 15),
(9, '2017-10-20', 21, 6),
(10, '2015-11-25', 21, 8),
(11, '2015-04-18', 21, 14),
(12, '2017-01-02', 21, 9),
(13, '2016-04-05', 21, 25),
(14, '2017-09-20', 21, 20),
(15, '2017-02-09', 21, 24),
(16, '2018-07-28', 21, 13),
(17, '2017-02-04', 21, 15),
(18, '2017-09-20', 21, 19),
(19, '2019-11-26', 21, 11),
(20, '2018-09-14', 21, 24),
(21, '2017-08-03', 21, 3),
(22, '2019-08-29', 21, 19),
(23, '2018-12-28', 21, 16),
(24, '2015-11-16', 21, 4),
(25, '2016-06-08', 21, 20),
(26, '2015-05-23', 21, 26),
(27, '2016-12-04', 21, 2),
(28, '2014-02-13', 21, 19),
(29, '2015-02-23', 21, 5),
(30, '2019-06-23', 21, 17),
(31, '2019-04-06', 21, 6),
(32, '2019-06-26', 21, 2),
(33, '2016-05-24', 21, 26),
(34, '2015-10-12', 21, 7),
(35, '2018-04-10', 21, 2),
(36, '2015-02-16', 21, 8),
(37, '2019-11-22', 21, 22),
(38, '2016-12-18', 21, 5),
(39, '2017-04-03', 21, 2),
(40, '2014-01-10', 21, 26),
(41, '2019-06-26', 21, 22),
(42, '2018-04-04', 21, 2),
(43, '2015-12-14', 21, 25),
(44, '2018-07-27', 21, 21),
(45, '2018-07-18', 21, 19),
(46, '2017-09-06', 21, 7),
(47, '2019-11-30', 21, 21),
(48, '2015-08-06', 21, 26),
(49, '2018-11-19', 21, 10),
(50, '2019-10-18', 21, 10),
(51, '2015-11-03', 21, 22),
(52, '2018-08-16', 21, 4),
(53, '2016-08-24', 21, 26),
(54, '2015-11-28', 21, 6),
(55, '2014-01-19', 21, 24),
(56, '2019-12-02', 21, 8),
(57, '2014-06-20', 21, 20),
(58, '2017-05-10', 21, 18),
(59, '2014-03-10', 21, 23),
(60, '2019-10-09', 21, 5),
(61, '2017-01-10', 21, 7),
(62, '2016-06-03', 21, 8),
(63, '2016-06-30', 21, 25),
(64, '2017-05-12', 21, 16),
(65, '2017-01-16', 21, 16),
(66, '2016-04-27', 21, 15),
(67, '2016-12-02', 21, 7),
(68, '2015-08-13', 21, 4),
(69, '2017-12-08', 21, 14),
(70, '2018-01-15', 21, 8),
(71, '2016-10-20', 21, 4),
(72, '2017-08-18', 21, 18),
(73, '2014-12-28', 21, 3),
(74, '2019-02-01', 21, 21),
(75, '2015-11-21', 21, 10),
(76, '2014-03-22', 21, 4),
(77, '2018-09-04', 21, 11),
(78, '2014-01-26', 21, 22),
(79, '2018-05-24', 21, 10),
(80, '2018-03-24', 21, 24),
(81, '2017-10-03', 21, 26),
(82, '2014-10-25', 21, 9),
(83, '2014-09-13', 21, 9),
(84, '2018-10-17', 21, 7),
(85, '2015-03-23', 21, 7),
(86, '2016-12-17', 21, 5),
(87, '2017-12-23', 21, 11),
(88, '2018-06-04', 21, 2),
(89, '2015-05-28', 21, 2),
(90, '2017-01-23', 21, 11),
(91, '2019-11-08', 21, 10),
(92, '2015-11-15', 21, 26),
(93, '2017-04-20', 21, 23),
(94, '2015-04-05', 21, 15),
(95, '2019-07-05', 21, 7),
(96, '2015-06-27', 21, 25),
(97, '2017-01-22', 21, 9),
(98, '2016-03-29', 21, 22),
(99, '2016-10-06', 21, 20),
(100, '2014-03-16', 21, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `codigo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `existencias` int(10) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `imagen` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tipo_producto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `codigo`, `existencias`, `precio`, `imagen`, `descripcion`, `tipo_producto_id`) VALUES
(1, '848684', 685, '4.67', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  montar tubos. ', 1),
(2, '628759', 47, '8.61', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de emparejar. ', 4),
(3, '505237', 343, '2.29', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de manzana. ', 11),
(4, '109893', 679, '4.88', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de emparejar. ', 6),
(5, '639718', 511, '20.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de emparejar. ', 4),
(6, '805252', 979, '2.78', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de emparejar. ', 7),
(7, '725134', 910, '67.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de dientes. ', 11),
(8, '697168', 244, '4.81', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  dientes. ', 11),
(9, '838960', 147, '2.25', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de manzana. ', 2),
(10, '491246', 598, '5.64', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  emparejar. ', 12),
(11, '387858', 986, '5.37', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  montar tubos. ', 9),
(12, '675543', 500, '7.69', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  dientes. ', 7),
(13, '413051', 427, '6.06', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de manzana. ', 9),
(14, '423746', 345, '6.25', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de emparejar. ', 6),
(15, '921257', 381, '6.01', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  dientes. ', 4),
(16, '291390', 953, '5.89', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de dientes. ', 12),
(17, '577636', 597, '1.41', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  dientes. ', 10),
(18, '970027', 997, '1.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  manzana. ', 7),
(19, '843914', 799, '3.68', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de montar tubos. ', 8),
(20, '467250', 459, '3.63', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  dientes. ', 9),
(21, '803254', 224, '8.89', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de montar tubos. ', 11),
(22, '134097', 7, '5.91', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Interruptor para montar tubos. ', 8),
(23, '922723', 960, '44.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de manzana. ', 9),
(24, '699606', 675, '2.44', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de montar tubos. ', 3),
(25, '361834', 488, '4.10', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para emparejar. ', 1),
(26, '674215', 729, '2.27', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de manzana. ', 1),
(27, '571253', 666, '9.32', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  montar tubos. ', 10),
(28, '548899', 655, '8.96', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  montar tubos. ', 2),
(29, '877481', 287, '3.74', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de montar tubos. ', 10),
(30, '940270', 275, '5.75', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de manzana. ', 11),
(31, '437450', 228, '5.96', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de dientes. ', 6),
(32, '478394', 230, '1.64', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de montar tubos. ', 3),
(33, '250188', 599, '7.69', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para manzana. ', 10),
(34, '714222', 187, '7.30', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para montar tubos. ', 1),
(35, '742062', 297, '9.30', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de montar tubos. ', 2),
(36, '768248', 887, '5.46', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de dientes. ', 10),
(37, '716719', 608, '2.90', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de montar tubos. ', 9),
(38, '577070', 374, '4.38', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de montar tubos. ', 3),
(39, '182572', 204, '3.32', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  dientes. ', 12),
(40, '116625', 955, '2.53', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de montar tubos. ', 4),
(41, '399159', 926, '8.01', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de dientes. ', 9),
(42, '131473', 543, '5.24', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de manzana. ', 7),
(43, '311450', 415, '1.32', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  dientes. ', 2),
(44, '140752', 179, '6.69', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de emparejar. ', 11),
(45, '968430', 103, '2.59', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para manzana. ', 5),
(46, '580596', 882, '5.82', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de montar tubos. ', 4),
(47, '732245', 553, '1.63', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  montar tubos. ', 10),
(48, '407546', 269, '7.06', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de manzana. ', 3),
(49, '117643', 259, '1.10', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de manzana. ', 9),
(50, '600741', 892, '3.45', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para montar tubos. ', 9),
(51, '532293', 732, '6.69', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de emparejar. ', 6),
(52, '955706', 552, '4.43', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de manzana. ', 1),
(53, '198137', 362, '9.63', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de manzana. ', 10),
(54, '547949', 62, '4.99', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para emparejar. ', 9),
(55, '286749', 666, '7.52', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de emparejar. ', 6),
(56, '319181', 666, '8.42', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de montar tubos. ', 12),
(57, '719929', 113, '3.14', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de emparejar. ', 6),
(58, '707069', 572, '8.78', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de montar tubos. ', 10),
(59, '525190', 61, '2.09', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  manzana. ', 6),
(60, '225440', 118, '1.41', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de emparejar. ', 5),
(61, '857524', 882, '1.49', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de montar tubos. ', 9),
(62, '725602', 317, '94.00', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  emparejar. ', 11),
(63, '549229', 344, '9.14', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de montar tubos. ', 1),
(64, '821226', 617, '6.53', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para montar tubos. ', 5),
(65, '832101', 457, '5.81', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de emparejar. ', 11),
(66, '374217', 287, '6.91', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Interruptor para montar tubos. ', 12),
(67, '627320', 691, '8.81', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de dientes. ', 7),
(68, '473237', 328, '3.87', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para emparejar. ', 2),
(69, '261660', 573, '43.00', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para manzana. ', 10),
(70, '540911', 843, '8.26', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de montar tubos. ', 5),
(71, '871406', 582, '7.36', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de montar tubos. ', 9),
(72, '201683', 559, '8.04', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de emparejar. ', 2),
(73, '481949', 393, '1.41', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  emparejar. ', 8),
(74, '696591', 448, '2.93', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  dientes. ', 2),
(75, '319078', 901, '6.19', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para montar tubos. ', 9),
(76, '530710', 955, '5.28', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de montar tubos. ', 9),
(77, '342866', 96, '28.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de emparejar. ', 2),
(78, '266212', 194, '4.86', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de montar tubos. ', 11),
(79, '204573', 690, '4.82', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  dientes. ', 10),
(80, '381391', 959, '5.80', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de montar tubos. ', 11),
(81, '377467', 731, '5.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de manzana. ', 2),
(82, '401625', 865, '4.98', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  dientes. ', 8),
(83, '702269', 184, '3.00', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  montar tubos. ', 3),
(84, '590308', 155, '9.58', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  dientes. ', 2),
(85, '423871', 341, '1.35', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  emparejar. ', 5),
(86, '179957', 317, '1.31', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Interruptor para emparejar. ', 5),
(87, '967205', 741, '10.00', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de manzana. ', 11),
(88, '309695', 132, '7.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  emparejar. ', 10),
(89, '554038', 124, '8.26', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para montar tubos. ', 7),
(90, '744536', 687, '26.00', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  emparejar. ', 5),
(91, '578729', 590, '8.31', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de montar tubos. ', 9),
(92, '633685', 659, '37.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para montar tubos. ', 8),
(93, '927784', 81, '7.08', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  dientes. ', 10),
(94, '364346', 309, '5.12', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para emparejar. ', 3),
(95, '615539', 79, '2.51', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de manzana. ', 10),
(96, '899426', 286, '1.41', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  montar tubos. ', 12),
(97, '545353', 190, '6.36', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de emparejar. ', 7),
(98, '712436', 230, '8.00', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de manzana. ', 4),
(99, '153170', 280, '87.00', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para manzana. ', 3),
(100, '831606', 976, '9.35', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para manzana. ', 12),
(101, '717487', 607, '3.15', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de dientes. ', 10),
(102, '453897', 920, '20.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de manzana. ', 12),
(103, '578400', 369, '5.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de emparejar. ', 1),
(104, '734428', 4, '2.71', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de emparejar. ', 7),
(105, '308163', 810, '8.81', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de manzana. ', 5),
(106, '189739', 97, '8.24', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  montar tubos. ', 11),
(107, '959094', 143, '3.13', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de dientes. ', 1),
(108, '586122', 138, '5.62', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para montar tubos. ', 3),
(109, '232012', 906, '7.23', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para emparejar. ', 10),
(110, '224426', 575, '9.55', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de emparejar. ', 7),
(111, '792660', 458, '75.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de manzana. ', 6),
(112, '257791', 99, '5.08', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de dientes. ', 2),
(113, '905933', 501, '9.95', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para montar tubos. ', 3),
(114, '611812', 728, '4.53', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de manzana. ', 4),
(115, '281610', 124, '4.35', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para manzana. ', 11),
(116, '760692', 350, '3.83', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de manzana. ', 9),
(117, '762496', 669, '5.47', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de montar tubos. ', 7),
(118, '786867', 422, '6.89', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para dientes. ', 1),
(119, '950607', 993, '5.09', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de dientes. ', 11),
(120, '424042', 581, '13.00', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Interruptor para emparejar. ', 3),
(121, '131487', 570, '4.48', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de montar tubos. ', 12),
(122, '508843', 275, '2.50', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de emparejar. ', 6),
(123, '625952', 584, '3.73', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  emparejar. ', 3),
(124, '818969', 626, '7.93', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de montar tubos. ', 1),
(125, '785276', 183, '8.83', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  dientes. ', 8),
(126, '525415', 695, '9.83', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para emparejar. ', 3),
(127, '545590', 563, '4.76', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de emparejar. ', 10),
(128, '473459', 162, '8.37', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de dientes. ', 4),
(129, '523699', 453, '9.82', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de dientes. ', 5),
(130, '216853', 447, '8.42', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de emparejar. ', 5),
(131, '555570', 842, '2.82', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  montar tubos. ', 1),
(132, '367955', 225, '3.81', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  montar tubos. ', 12),
(133, '844711', 911, '13.00', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para montar tubos. ', 5),
(134, '394403', 396, '5.61', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de montar tubos. ', 2),
(135, '377242', 845, '34.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de emparejar. ', 6),
(136, '161732', 520, '1.41', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de emparejar. ', 12),
(137, '208344', 423, '5.00', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de dientes. ', 11),
(138, '107824', 721, '5.61', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  manzana. ', 7),
(139, '498578', 735, '3.59', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de montar tubos. ', 10),
(140, '876215', 483, '1.92', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  manzana. ', 5),
(141, '353314', 319, '15.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de montar tubos. ', 9),
(142, '563416', 66, '6.93', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  montar tubos. ', 8),
(143, '752625', 995, '8.17', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  dientes. ', 6),
(144, '753161', 294, '2.34', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  manzana. ', 5),
(145, '668145', 594, '7.93', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de dientes. ', 11),
(146, '765890', 63, '5.78', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Interruptor para montar tubos. ', 4),
(147, '196424', 831, '6.11', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  dientes. ', 5),
(148, '412869', 382, '8.85', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para emparejar. ', 4),
(149, '951748', 221, '8.65', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de dientes. ', 6),
(150, '775051', 177, '3.71', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  emparejar. ', 2),
(151, '394622', 261, '4.19', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para montar tubos. ', 11),
(152, '660616', 476, '7.25', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de emparejar. ', 5),
(153, '522135', 896, '93.00', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de montar tubos. ', 8),
(154, '711547', 51, '6.88', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de montar tubos. ', 7),
(155, '243581', 637, '7.12', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  emparejar. ', 12),
(156, '128046', 906, '3.59', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para dientes. ', 7),
(157, '246312', 733, '3.53', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de emparejar. ', 2),
(158, '354808', 404, '3.63', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para emparejar. ', 11),
(159, '743896', 574, '9.63', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de manzana. ', 5),
(160, '290423', 708, '7.32', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  montar tubos. ', 4),
(161, '869375', 443, '1.25', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de manzana. ', 12),
(162, '550825', 48, '3.98', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para manzana. ', 1),
(163, '142112', 937, '8.79', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de emparejar. ', 7),
(164, '470533', 55, '2.33', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de manzana. ', 12),
(165, '916424', 607, '8.98', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de emparejar. ', 9),
(166, '787540', 793, '2.02', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Interruptor para dientes. ', 7),
(167, '315754', 592, '1.73', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para emparejar. ', 4),
(168, '725426', 649, '9.13', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para montar tubos. ', 1),
(169, '727142', 469, '1.49', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de manzana. ', 7),
(170, '601390', 818, '7.63', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  emparejar. ', 1),
(171, '369915', 105, '3.73', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para emparejar. ', 10),
(172, '913285', 67, '2.95', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de emparejar. ', 3),
(173, '559766', 508, '1.07', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de dientes. ', 6),
(174, '949937', 613, '9.02', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para manzana. ', 8),
(175, '448239', 441, '9.16', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de dientes. ', 5),
(176, '454394', 391, '7.92', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  emparejar. ', 8),
(177, '468631', 773, '1.72', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de montar tubos. ', 10),
(178, '422517', 728, '1.33', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para manzana. ', 7),
(179, '436492', 18, '40.00', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para montar tubos. ', 8),
(180, '532527', 203, '7.71', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de manzana. ', 4),
(181, '317579', 528, '6.34', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Interruptor para manzana. ', 6),
(182, '963484', 383, '9.72', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  manzana. ', 5),
(183, '352780', 137, '33.00', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de montar tubos. ', 5),
(184, '430986', 626, '6.25', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de dientes. ', 5),
(185, '340272', 325, '2.96', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de emparejar. ', 2),
(186, '350896', 437, '7.39', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para emparejar. ', 7),
(187, '875061', 926, '44.00', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para dientes. ', 12),
(188, '161142', 162, '39.00', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  emparejar. ', 8),
(189, '797765', 2, '6.99', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de emparejar. ', 10),
(190, '707348', 376, '9.97', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de dientes. ', 8),
(191, '553727', 433, '9.34', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  emparejar. ', 3),
(192, '520483', 21, '8.01', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de dientes. ', 9),
(193, '713737', 475, '9.21', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de emparejar. ', 12),
(194, '419214', 702, '8.03', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de dientes. ', 3),
(195, '694851', 397, '6.62', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de manzana. ', 3),
(196, '312044', 964, '1.37', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Interruptor para montar tubos. ', 3),
(197, '388317', 403, '3.29', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de montar tubos. ', 12),
(198, '405647', 590, '8.72', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  montar tubos. ', 8),
(199, '278103', 576, '2.65', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de montar tubos. ', 9),
(200, '767487', 7, '4.97', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de dientes. ', 8),
(201, '602709', 941, '2.38', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de emparejar. ', 8),
(202, '809481', 718, '5.79', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Interruptor para montar tubos. ', 8),
(203, '492383', 193, '8.12', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de montar tubos. ', 1),
(204, '542248', 887, '1.99', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de emparejar. ', 10),
(205, '928690', 897, '1.63', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  montar tubos. ', 4),
(206, '578564', 977, '4.60', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de manzana. ', 5),
(207, '231887', 212, '6.32', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de emparejar. ', 2),
(208, '892782', 937, '94.00', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Bebida de  manzana. ', 12),
(209, '649484', 489, '2.36', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de montar tubos. ', 3),
(210, '568036', 112, '5.26', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  dientes. ', 9),
(211, '495601', 699, '6.80', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de manzana. ', 9),
(212, '303334', 776, '6.62', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  emparejar. ', 9),
(213, '281673', 830, '3.98', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para manzana. ', 4),
(214, '221741', 440, '2.46', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de montar tubos. ', 3),
(215, '374182', 425, '1.88', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de montar tubos. ', 3),
(216, '202572', 333, '5.89', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para dientes. ', 3),
(217, '361508', 996, '1.76', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de emparejar. ', 9),
(218, '984193', 503, '5.13', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para montar tubos. ', 8),
(219, '589649', 267, '6.24', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para manzana. ', 10),
(220, '199003', 824, '8.69', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de montar tubos. ', 8),
(221, '623344', 215, '2.13', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  dientes. ', 1),
(222, '853418', 859, '2.73', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  montar tubos. ', 12),
(223, '975570', 659, '5.60', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Maquina de manzana. ', 3),
(224, '768292', 650, '9.77', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Maquina de dientes. ', 10),
(225, '752907', 312, '2.31', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Maquina de dientes. ', 3),
(226, '909496', 268, '7.53', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de montar tubos. ', 4),
(227, '148139', 575, '2.21', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Interruptor para emparejar. ', 11),
(228, '545442', 650, '4.27', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  dientes. ', 7),
(229, '743698', 12, '7.51', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para emparejar. ', 11),
(230, '443779', 195, '4.23', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para emparejar. ', 7),
(231, '622000', 995, '4.31', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para dientes. ', 6),
(232, '310200', 804, '3.63', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  montar tubos. ', 5),
(233, '821090', 101, '7.66', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de montar tubos. ', 8),
(234, '769504', 904, '8.77', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de dientes. ', 6),
(235, '668733', 889, '1.14', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de emparejar. ', 2),
(236, '205196', 244, '4.32', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de emparejar. ', 2),
(237, '725499', 762, '4.85', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Interruptor para dientes. ', 7),
(238, '615926', 401, '8.34', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Bebida de  montar tubos. ', 6),
(239, '800520', 33, '7.58', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Libro de emparejar. ', 9),
(240, '592944', 387, '2.72', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de manzana. ', 3),
(241, '363514', 582, '4.45', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  manzana. ', 8),
(242, '295085', 136, '3.33', 'https://www.revistacambio.com.mx/wp-content/uploads/2019/10/istock-640143244-1-300x200.jpg', 'Libro de emparejar. ', 1),
(243, '486877', 814, '56.00', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  manzana. ', 10),
(244, '240235', 133, '4.35', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Libro de dientes. ', 12),
(245, '343969', 861, '5.61', 'https://www.aimdigital.com.ar/wp-content/uploads/2018/07/alimentos-cifra-300x200.jpg', 'Bebida de  dientes. ', 7),
(246, '782977', 694, '7.00', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de emparejar. ', 12),
(247, '378205', 365, '4.22', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Maquina de manzana. ', 9),
(248, '216322', 289, '4.12', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Interruptor para emparejar. ', 11),
(249, '714673', 857, '1.33', 'http://www.entretantomagazine.com/wp-content/uploads/2018/02/salad-2756467_1920-300x200.jpg', 'Bebida de  dientes. ', 5),
(250, '875163', 658, '26.00', 'https://blog.cofciudadreal.com/wp-content/uploads/2017/12/duck-2957809__340-300x200.jpg', 'Libro de manzana. ', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_producto`
--

CREATE TABLE `tipo_producto` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_producto`
--

INSERT INTO `tipo_producto` (`id`, `descripcion`) VALUES
(1, 'Higiene de la empresa. '),
(2, 'Juguetes para centros educativos. '),
(3, 'Juguetes de la empresa. '),
(4, 'Juguetes del hogar. '),
(5, 'Alimentación para centros educativos. '),
(6, 'Alimentación sanitaria. '),
(7, 'Alimentación de la empresa. '),
(8, 'Electronica sanitaria. '),
(9, 'Higiene de la empresa. '),
(10, 'Alimentación del hogar. '),
(11, 'Higiene para centros educativos. '),
(12, 'Electronica del hogar. '),
(13, 'Electronica de la empresa. '),
(14, 'Higiene de la empresa. '),
(15, 'Alimentación sanitaria. '),
(16, 'Juguetes del hogar. '),
(17, 'Alimentación para centros educativos. '),
(18, 'Alimentación sanitaria. '),
(19, 'Juguetes de la empresa. '),
(20, 'Electronica sanitaria. '),
(21, 'Electronica sanitaria. '),
(22, 'Electronica de la empresa. '),
(23, 'Higiene sanitaria. '),
(24, 'Juguetes del hogar. '),
(25, 'Electronica sanitaria. '),
(26, 'Alimentación para centros educativos. '),
(27, 'Juguetes de la empresa. '),
(28, 'Higiene del hogar. '),
(29, 'Juguetes sanitaria. '),
(30, 'Electronica para centros educativos. '),
(31, 'Higiene del hogar. '),
(32, 'Electronica para centros educativos. '),
(33, 'Electronica para centros educativos. '),
(34, 'Alimentación del hogar. '),
(35, 'Electronica de la empresa. '),
(36, 'Higiene sanitaria. '),
(37, 'Electronica de la empresa. '),
(38, 'Alimentación sanitaria. '),
(39, 'Alimentación del hogar. '),
(40, 'Alimentación de la empresa. '),
(41, 'Higiene para centros educativos. '),
(42, 'Electronica para centros educativos. '),
(43, 'Higiene del hogar. '),
(44, 'Electronica del hogar. '),
(45, 'Alimentación del hogar. '),
(46, 'Electronica sanitaria. '),
(47, 'Alimentación para centros educativos. '),
(48, 'Alimentación sanitaria. '),
(49, 'Juguetes del hogar. '),
(50, 'Alimentación para centros educativos. '),
(51, 'Alimentación sanitaria. '),
(52, 'Higiene de la empresa. '),
(53, 'Electronica del hogar. '),
(54, 'Higiene del hogar. '),
(55, 'Electronica de la empresa. '),
(56, 'Juguetes para centros educativos. '),
(57, 'Electronica de la empresa. '),
(58, 'Electronica del hogar. '),
(59, 'Electronica sanitaria. '),
(60, 'Higiene del hogar. '),
(61, 'Higiene sanitaria. '),
(62, 'Juguetes del hogar. '),
(63, 'Electronica de la empresa. '),
(64, 'Juguetes de la empresa. '),
(65, 'Juguetes de la empresa. '),
(66, 'Juguetes para centros educativos. '),
(67, 'Alimentación de la empresa. '),
(68, 'Juguetes sanitaria. '),
(69, 'Higiene sanitaria. '),
(70, 'Juguetes sanitaria. '),
(71, 'Electronica sanitaria. '),
(72, 'Alimentación de la empresa. '),
(73, 'Higiene sanitaria. '),
(74, 'Juguetes para centros educativos. '),
(75, 'Electronica de la empresa. '),
(76, 'Juguetes sanitaria. '),
(77, 'Alimentación sanitaria. '),
(78, 'Juguetes del hogar. '),
(79, 'Juguetes de la empresa. '),
(80, 'Higiene de la empresa. '),
(81, 'Alimentación para centros educativos. '),
(82, 'Electronica para centros educativos. '),
(83, 'Higiene para centros educativos. '),
(84, 'Juguetes del hogar. '),
(85, 'Alimentación de la empresa. '),
(86, 'Juguetes sanitaria. '),
(87, 'Electronica de la empresa. '),
(88, 'Alimentación para centros educativos. '),
(89, 'Electronica sanitaria. '),
(90, 'Electronica sanitaria. '),
(91, 'Juguetes sanitaria. '),
(92, 'Alimentación sanitaria. '),
(93, 'Alimentación para centros educativos. '),
(94, 'Electronica del hogar. '),
(95, 'Electronica del hogar. '),
(96, 'Juguetes para centros educativos. '),
(97, 'Alimentación de la empresa. '),
(98, 'Juguetes sanitaria. '),
(99, 'Higiene de la empresa. '),
(100, 'Electronica para centros educativos. ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id`, `descripcion`) VALUES
(1, 'Administrador'),
(2, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `dni` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `apellido1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `apellido2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `login` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tipo_usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `dni`, `nombre`, `apellido1`, `apellido2`, `login`, `password`, `email`, `tipo_usuario_id`) VALUES
(1, '12345678A', 'Troll', 'Eyes', 'Daw', 'trolleyes', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'troll@eyes.com', 1),
(2, '30380657O', 'Marcel·li', 'de les', 'Palla', 'madepa5597', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madepa5597@trolleyes.com', 2),
(3, '74207971O', 'Marcel·li', 'de la', 'Llobarro', 'madell4582', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madell4582@trolleyes.com', 2),
(4, '33315126O', 'Maurici', 'dels', 'Murallot', 'mademu8479', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mademu8479@trolleyes.com', 2),
(5, '42548227O', 'Cirili', 'Ca la', 'Palla', 'cicapa9140', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cicapa9140@trolleyes.com', 2),
(6, '30420869O', 'Pepet', 'dels', 'Clapés', 'pedecl9073', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pedecl9073@trolleyes.com', 2),
(7, '59725402O', 'Josepa', 'de Cal', 'Murallot', 'jodemu6421', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jodemu6421@trolleyes.com', 2),
(8, '76459525O', 'Pepet', 'de la', 'Cigrons', 'pedeci7586', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pedeci7586@trolleyes.com', 2),
(9, '24376494O', 'Pompeu', 'Pacoco', 'Palla', 'popapa5989', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'popapa5989@trolleyes.com', 2),
(10, '34535786O', 'Maurici', 'de les', 'Pacoco', 'madepa2921', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madepa2921@trolleyes.com', 2),
(11, '11176664O', 'Eudald', 'de Cal', 'Cebes', 'eudece5161', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'eudece5161@trolleyes.com', 2),
(12, '71510920O', 'Marcel·li', 'Ca la', 'Palla', 'macapa4348', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'macapa4348@trolleyes.com', 2),
(13, '77369616O', 'Marcel·li', 'de Can', 'Trencapins', 'madetr3520', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madetr3520@trolleyes.com', 2),
(14, '53149178O', 'Vidal', 'de les', 'Cigrons', 'videci7492', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'videci7492@trolleyes.com', 2),
(15, '62531407O', 'Marcel·li', 'de Can', 'Faves', 'madefa4924', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madefa4924@trolleyes.com', 2),
(16, '66385893O', 'Maurici', 'de Can', 'Palla', 'madepa8109', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madepa8109@trolleyes.com', 2),
(17, '93599057O', 'Pompeu', 'de la', 'Trencapins', 'podetr4688', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'podetr4688@trolleyes.com', 2),
(18, '31279111O', 'Miqueleta', 'de Can', 'Murallot', 'midemu9127', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'midemu9127@trolleyes.com', 2),
(19, '52165377O', 'Cirili', 'de les', 'Murallot', 'cidemu7887', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cidemu7887@trolleyes.com', 2),
(20, '35029836O', 'Jaumet', 'dels', 'Murallot', 'jademu4189', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jademu4189@trolleyes.com', 2),
(21, '79660819O', 'Pepet', 'de Can', 'Palla', 'pedepa9099', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pedepa9099@trolleyes.com', 2),
(22, '79294744O', 'Jaumet', 'de la', 'Freda', 'jadefr3182', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadefr3182@trolleyes.com', 2),
(23, '51348820O', 'Domènec', 'dels', 'Trencapins', 'dodetr7706', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dodetr7706@trolleyes.com', 2),
(24, '50953490O', 'Jaumet', 'de Cal', 'Metge', 'jademe1777', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jademe1777@trolleyes.com', 2),
(25, '85559217O', 'Vidal', 'de Can', 'Faves', 'videfa6818', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'videfa6818@trolleyes.com', 2),
(26, '50833168O', 'Marcel·li', 'de la', 'Llobarro', 'madell1523', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madell1523@trolleyes.com', 2),
(27, '91749104O', 'Domènec', 'el de', 'Murallot', 'doelmu8256', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'doelmu8256@trolleyes.com', 2),
(28, '41656754O', 'Cirili', 'el de', 'Palla', 'cielpa8060', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cielpa8060@trolleyes.com', 2),
(29, '36755685O', 'Maurici', 'de la', 'Cargols', 'madeca7795', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madeca7795@trolleyes.com', 2),
(30, '71910358O', 'Pepet', 'de Cal', 'Porrons', 'pedepo7314', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pedepo7314@trolleyes.com', 2),
(31, '72903037O', 'Maurici', 'Ca la', 'Cargols', 'macaca6133', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'macaca6133@trolleyes.com', 2),
(32, '29375286O', 'Jaumet', 'de les', 'Llobarro', 'jadell3132', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadell3132@trolleyes.com', 2),
(33, '74825449O', 'Maurici', 'de les', 'Pacoco', 'madepa4315', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madepa4315@trolleyes.com', 2),
(34, '13922528O', 'Miqueleta', 'el de', 'Cargols', 'mielca5676', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mielca5676@trolleyes.com', 2),
(35, '42323360O', 'Cirili', 'dels', 'Murallot', 'cidemu3248', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cidemu3248@trolleyes.com', 2),
(36, '12716205O', 'Eudald', 'de les', 'Cargols', 'eudeca1591', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'eudeca1591@trolleyes.com', 2),
(37, '58092589O', 'Vidal', 'de Cal', 'Metge', 'videme4623', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'videme4623@trolleyes.com', 2),
(38, '40333672O', 'Marcel·li', 'Ca la', 'Pacoco', 'macapa2552', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'macapa2552@trolleyes.com', 2),
(39, '58550440O', 'Bernat', 'el de', 'Murallot', 'beelmu8331', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'beelmu8331@trolleyes.com', 2),
(40, '96317634O', 'Cirili', 'de Cal', 'Faves', 'cidefa6483', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cidefa6483@trolleyes.com', 2),
(41, '80479290O', 'Marcel·li', 'dels', 'Metge', 'mademe6846', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mademe6846@trolleyes.com', 2),
(42, '42382270O', 'Bernat', 'de Cal', 'Cigrons', 'bedeci2595', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'bedeci2595@trolleyes.com', 2),
(43, '11044053O', 'Pompeu', 'de Cal', 'Cebes', 'podece3240', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'podece3240@trolleyes.com', 2),
(44, '11672627O', 'Pompeu', 'de la', 'Porrons', 'podepo7311', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'podepo7311@trolleyes.com', 2),
(45, '84607772O', 'Eudald', 'dels', 'Cigrons', 'eudeci2285', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'eudeci2285@trolleyes.com', 2),
(46, '23114704O', 'Cirili', 'Pacoco', 'Pacoco', 'cipapa9259', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cipapa9259@trolleyes.com', 2),
(47, '20331748O', 'Jaumet', 'el de', 'Palla', 'jaelpa9623', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jaelpa9623@trolleyes.com', 2),
(48, '81701399O', 'Jaumet', 'el de', 'Murallot', 'jaelmu3209', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jaelmu3209@trolleyes.com', 2),
(49, '93933671O', 'Paco', 'dels', 'Cigrons', 'padeci5265', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'padeci5265@trolleyes.com', 2),
(50, '91465056O', 'Cirili', 'Ca la', 'Metge', 'cicame8520', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cicame8520@trolleyes.com', 2),
(51, '27289219O', 'Vidal', 'de les', 'Trencapins', 'videtr9792', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'videtr9792@trolleyes.com', 2),
(52, '94536665O', 'Paco', 'dels', 'Clapés', 'padecl2213', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'padecl2213@trolleyes.com', 2),
(53, '38367331O', 'Jaumet', 'de Cal', 'Llobarro', 'jadell8926', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadell8926@trolleyes.com', 2),
(54, '18950548O', 'Pompeu', 'de les', 'Faves', 'podefa1648', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'podefa1648@trolleyes.com', 2),
(55, '11824549O', 'Marcel·li', 'de Cal', 'Faves', 'madefa1452', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madefa1452@trolleyes.com', 2),
(56, '68305208O', 'Jaumet', 'el de', 'Palla', 'jaelpa3569', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jaelpa3569@trolleyes.com', 2),
(57, '38454736O', 'Maurici', 'Ca la', 'Trencapins', 'macatr4580', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'macatr4580@trolleyes.com', 2),
(58, '60839022O', 'Miqueleta', 'de Can', 'Faves', 'midefa5415', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'midefa5415@trolleyes.com', 2),
(59, '58572293O', 'Eudald', 'dels', 'Clapés', 'eudecl9464', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'eudecl9464@trolleyes.com', 2),
(60, '58444683O', 'Josepa', 'de Can', 'Cigrons', 'jodeci4540', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jodeci4540@trolleyes.com', 2),
(61, '64742535O', 'Cirili', 'dels', 'Murallot', 'cidemu2684', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cidemu2684@trolleyes.com', 2),
(62, '21369463O', 'Cirili', 'dels', 'Palla', 'cidepa7815', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cidepa7815@trolleyes.com', 2),
(63, '40474717O', 'Maurici', 'dels', 'Porrons', 'madepo4810', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madepo4810@trolleyes.com', 2),
(64, '92288022O', 'Domènec', 'de les', 'Cargols', 'dodeca4918', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dodeca4918@trolleyes.com', 2),
(65, '21441833O', 'Miqueleta', 'de la', 'Cigrons', 'mideci3911', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mideci3911@trolleyes.com', 2),
(66, '78768627O', 'Domènec', 'de Can', 'Pacoco', 'dodepa9973', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dodepa9973@trolleyes.com', 2),
(67, '40336597O', 'Paco', 'el de', 'Trencapins', 'paeltr4573', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'paeltr4573@trolleyes.com', 2),
(68, '82278669O', 'Jaumet', 'de la', 'Porrons', 'jadepo9583', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadepo9583@trolleyes.com', 2),
(69, '46933174O', 'Pepet', 'de Can', 'Palla', 'pedepa8368', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pedepa8368@trolleyes.com', 2),
(70, '20406548O', 'Pepet', 'de la', 'Cebes', 'pedece5368', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pedece5368@trolleyes.com', 2),
(71, '95586406O', 'Domènec', 'Ca la', 'Cigrons', 'docaci4006', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'docaci4006@trolleyes.com', 2),
(72, '99248194O', 'Jaumet', 'Pacoco', 'Murallot', 'japamu7959', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'japamu7959@trolleyes.com', 2),
(73, '48020380O', 'Miqueleta', 'de Cal', 'Llobarro', 'midell5681', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'midell5681@trolleyes.com', 2),
(74, '91470682O', 'Pompeu', 'de Can', 'Cebes', 'podece8722', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'podece8722@trolleyes.com', 2),
(75, '72560744O', 'Jaumet', 'dels', 'Cigrons', 'jadeci9575', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadeci9575@trolleyes.com', 2),
(76, '80693759O', 'Domènec', 'de les', 'Pacoco', 'dodepa9982', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dodepa9982@trolleyes.com', 2),
(77, '70143611O', 'Maurici', 'Pacoco', 'Metge', 'mapame7394', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mapame7394@trolleyes.com', 2),
(78, '82013176O', 'Paco', 'de Cal', 'Trencapins', 'padetr5086', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'padetr5086@trolleyes.com', 2),
(79, '73650292O', 'Maurici', 'de Can', 'Cargols', 'madeca5263', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madeca5263@trolleyes.com', 2),
(80, '35936223O', 'Pepet', 'de Cal', 'Murallot', 'pedemu9415', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pedemu9415@trolleyes.com', 2),
(81, '52002288O', 'Cirili', 'de la', 'Porrons', 'cidepo7996', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cidepo7996@trolleyes.com', 2),
(82, '27137752O', 'Paco', 'Ca la', 'Cigrons', 'pacaci6543', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pacaci6543@trolleyes.com', 2),
(83, '13604647O', 'Josepa', 'dels', 'Clapés', 'jodecl2480', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jodecl2480@trolleyes.com', 2),
(84, '70420524O', 'Vidal', 'dels', 'Pacoco', 'videpa9804', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'videpa9804@trolleyes.com', 2),
(85, '70216233O', 'Pompeu', 'el de', 'Murallot', 'poelmu2806', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'poelmu2806@trolleyes.com', 2),
(86, '53442394O', 'Jaumet', 'Ca la', 'Metge', 'jacame1819', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jacame1819@trolleyes.com', 2),
(87, '80189763O', 'Pepet', 'el de', 'Cebes', 'peelce1484', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'peelce1484@trolleyes.com', 2),
(88, '25238387O', 'Vidal', 'Pacoco', 'Palla', 'vipapa5260', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'vipapa5260@trolleyes.com', 2),
(89, '87768609O', 'Cirili', 'de les', 'Faves', 'cidefa3974', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cidefa3974@trolleyes.com', 2),
(90, '71621081O', 'Bernat', 'dels', 'Faves', 'bedefa1686', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'bedefa1686@trolleyes.com', 2),
(91, '19225818O', 'Cirili', 'de la', 'Trencapins', 'cidetr7465', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cidetr7465@trolleyes.com', 2),
(92, '45209218O', 'Paco', 'de Cal', 'Porrons', 'padepo2404', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'padepo2404@trolleyes.com', 2),
(93, '29026990O', 'Vidal', 'Pacoco', 'Porrons', 'vipapo1016', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'vipapo1016@trolleyes.com', 2),
(94, '40352436O', 'Marcel·li', 'de Cal', 'Murallot', 'mademu9569', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mademu9569@trolleyes.com', 2),
(95, '34804738O', 'Bernat', 'de Can', 'Freda', 'bedefr9201', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'bedefr9201@trolleyes.com', 2),
(96, '99548414O', 'Domènec', 'dels', 'Cargols', 'dodeca9397', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dodeca9397@trolleyes.com', 2),
(97, '54129128O', 'Domènec', 'dels', 'Faves', 'dodefa9469', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dodefa9469@trolleyes.com', 2),
(98, '30265267O', 'Paco', 'dels', 'Pacoco', 'padepa4093', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'padepa4093@trolleyes.com', 2),
(99, '42195625O', 'Paco', 'dels', 'Porrons', 'padepo5614', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'padepo5614@trolleyes.com', 2),
(100, '83283202O', 'Maurici', 'de la', 'Metge', 'mademe5824', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mademe5824@trolleyes.com', 2),
(101, '76447700O', 'Bernat', 'el de', 'Murallot', 'beelmu2597', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'beelmu2597@trolleyes.com', 2),
(102, '78870592O', 'Jaumet', 'dels', 'Cebes', 'jadece8460', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadece8460@trolleyes.com', 2),
(103, '93592810O', 'Domènec', 'Pacoco', 'Murallot', 'dopamu8517', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dopamu8517@trolleyes.com', 2),
(104, '25144437O', 'Vidal', 'el de', 'Cebes', 'vielce9424', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'vielce9424@trolleyes.com', 2),
(105, '98713566O', 'Jaumet', 'de les', 'Cargols', 'jadeca3469', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadeca3469@trolleyes.com', 2),
(106, '57886850O', 'Bernat', 'de Cal', 'Cigrons', 'bedeci4627', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'bedeci4627@trolleyes.com', 2),
(107, '65445241O', 'Domènec', 'de les', 'Cigrons', 'dodeci7441', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dodeci7441@trolleyes.com', 2),
(108, '38668700O', 'Eudald', 'de la', 'Murallot', 'eudemu4269', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'eudemu4269@trolleyes.com', 2),
(109, '16179820O', 'Jaumet', 'de Cal', 'Pacoco', 'jadepa2245', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadepa2245@trolleyes.com', 2),
(110, '13359575O', 'Pompeu', 'dels', 'Metge', 'podeme7042', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'podeme7042@trolleyes.com', 2),
(111, '50627400O', 'Miqueleta', 'de les', 'Murallot', 'midemu1571', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'midemu1571@trolleyes.com', 2),
(112, '87688349O', 'Pompeu', 'de Cal', 'Pacoco', 'podepa3859', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'podepa3859@trolleyes.com', 2),
(113, '38949087O', 'Josepa', 'de les', 'Pacoco', 'jodepa5083', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jodepa5083@trolleyes.com', 2),
(114, '66389007O', 'Bernat', 'el de', 'Pacoco', 'beelpa7497', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'beelpa7497@trolleyes.com', 2),
(115, '29170918O', 'Miqueleta', 'Pacoco', 'Trencapins', 'mipatr6623', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mipatr6623@trolleyes.com', 2),
(116, '35268072O', 'Domènec', 'el de', 'Trencapins', 'doeltr1880', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'doeltr1880@trolleyes.com', 2),
(117, '20264362O', 'Jaumet', 'de Can', 'Llobarro', 'jadell4762', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadell4762@trolleyes.com', 2),
(118, '28128589O', 'Paco', 'de Can', 'Faves', 'padefa7119', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'padefa7119@trolleyes.com', 2),
(119, '87672580O', 'Maurici', 'dels', 'Cigrons', 'madeci6823', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madeci6823@trolleyes.com', 2),
(120, '86464809O', 'Miqueleta', 'de les', 'Freda', 'midefr1981', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'midefr1981@trolleyes.com', 2),
(121, '73178790O', 'Bernat', 'de les', 'Cebes', 'bedece4921', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'bedece4921@trolleyes.com', 2),
(122, '47004553O', 'Josepa', 'de Can', 'Cebes', 'jodece1989', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jodece1989@trolleyes.com', 2),
(123, '99828309O', 'Paco', 'Pacoco', 'Metge', 'papame9107', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'papame9107@trolleyes.com', 2),
(124, '80043833O', 'Pepet', 'de la', 'Murallot', 'pedemu5848', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pedemu5848@trolleyes.com', 2),
(125, '74572646O', 'Miqueleta', 'Pacoco', 'Freda', 'mipafr7667', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mipafr7667@trolleyes.com', 2),
(126, '98831298O', 'Maurici', 'de Can', 'Cigrons', 'madeci7076', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madeci7076@trolleyes.com', 2),
(127, '88814320O', 'Cirili', 'el de', 'Trencapins', 'cieltr2218', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cieltr2218@trolleyes.com', 2),
(128, '62477052O', 'Pepet', 'de les', 'Cargols', 'pedeca9160', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pedeca9160@trolleyes.com', 2),
(129, '82975897O', 'Maurici', 'de Can', 'Cargols', 'madeca6280', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'madeca6280@trolleyes.com', 2),
(130, '11659420O', 'Paco', 'Ca la', 'Metge', 'pacame8295', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pacame8295@trolleyes.com', 2),
(131, '16445521O', 'Josepa', 'Ca la', 'Freda', 'jocafr5508', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jocafr5508@trolleyes.com', 2),
(132, '59180556O', 'Domènec', 'de Can', 'Cebes', 'dodece5630', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dodece5630@trolleyes.com', 2),
(133, '55082570O', 'Paco', 'Ca la', 'Murallot', 'pacamu6792', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'pacamu6792@trolleyes.com', 2),
(134, '26792866O', 'Paco', 'de les', 'Freda', 'padefr6372', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'padefr6372@trolleyes.com', 2),
(135, '24187765O', 'Bernat', 'Ca la', 'Porrons', 'becapo7983', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'becapo7983@trolleyes.com', 2),
(136, '53016688O', 'Domènec', 'el de', 'Faves', 'doelfa9322', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'doelfa9322@trolleyes.com', 2),
(137, '25208282O', 'Vidal', 'de Cal', 'Clapés', 'videcl6414', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'videcl6414@trolleyes.com', 2),
(138, '35448788O', 'Miqueleta', 'de Cal', 'Pacoco', 'midepa6045', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'midepa6045@trolleyes.com', 2),
(139, '97184566O', 'Jaumet', 'de les', 'Cargols', 'jadeca4466', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadeca4466@trolleyes.com', 2),
(140, '98591870O', 'Jaumet', 'dels', 'Trencapins', 'jadetr3750', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'jadetr3750@trolleyes.com', 2),
(141, '42245098O', 'Domènec', 'dels', 'Trencapins', 'dodetr6960', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dodetr6960@trolleyes.com', 2),
(142, '77008254O', 'Pompeu', 'Pacoco', 'Cebes', 'popace7672', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'popace7672@trolleyes.com', 2),
(143, '14480292O', 'Cirili', 'Ca la', 'Murallot', 'cicamu2652', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'cicamu2652@trolleyes.com', 2),
(144, '12824702O', 'Domènec', 'Ca la', 'Clapés', 'docacl7916', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'docacl7916@trolleyes.com', 2),
(145, '19908080O', 'Domènec', 'de la', 'Pacoco', 'dodepa6847', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dodepa6847@trolleyes.com', 2),
(146, '49718119O', 'Miqueleta', 'de Cal', 'Clapés', 'midecl1838', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'midecl1838@trolleyes.com', 2),
(147, '76580937O', 'Miqueleta', 'de les', 'Cargols', 'mideca8388', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mideca8388@trolleyes.com', 2),
(148, '77639751O', 'Domènec', 'Pacoco', 'Faves', 'dopafa7478', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'dopafa7478@trolleyes.com', 2),
(149, '98245637O', 'Marcel·li', 'Pacoco', 'Palla', 'mapapa8613', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'mapapa8613@trolleyes.com', 2),
(150, '58053984O', 'Eudald', 'de les', 'Faves', 'eudefa1808', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'eudefa1808@trolleyes.com', 2),
(151, '15389997O', 'Bernat', 'de les', 'Metge', 'bedeme2561', 'da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04', 'bedeme2561@trolleyes.com', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id`,`factura_id`,`producto_id`),
  ADD KEY `fk_compra_factura_idx` (`factura_id`),
  ADD KEY `fk_compra_producto_idx` (`producto_id`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id`,`usuario_id`),
  ADD KEY `fk_factura_usuario_idx` (`usuario_id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`,`tipo_producto_id`),
  ADD KEY `fk_producto_tipo_producto_idx` (`tipo_producto_id`);

--
-- Indices de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`,`tipo_usuario_id`),
  ADD KEY `fk_usuario_tipo_usuario_idx` (`tipo_usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=301;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=251;

--
-- AUTO_INCREMENT de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=152;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `fk_compra_factura` FOREIGN KEY (`factura_id`) REFERENCES `factura` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_compra_producto` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_factura_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_tipo_producto` FOREIGN KEY (`tipo_producto_id`) REFERENCES `tipo_producto` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_tipo_usuario` FOREIGN KEY (`tipo_usuario_id`) REFERENCES `tipo_usuario` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
