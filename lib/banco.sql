-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-11-2022 a las 16:18:38
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `banco`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `id_gestor` int(11) NOT NULL,
  `usuario` char(20) NOT NULL,
  `password` char(64) NOT NULL,
  `correo` char(50) NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `id_gestor`, `usuario`, `password`, `correo`, `saldo`) VALUES
(1, 1, 'cliente', 'cliente', 'cliente@', 14),
(2, 1, 'aaa', 'aaa', 'aaa@', 111),
(3, 1, 'bbb', 'bbb', 'bbb@', 222),
(4, 1, 'ccc', 'ccc', 'ccc@', 333),
(5, 1, 'ddd', 'ddd', 'ddd@', 444),
(6, 1, 'eee', 'eee', 'eee@', 555),
(7, 1, 'ggg', 'ggg', 'ggg@', 444);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gestor`
--

CREATE TABLE `gestor` (
  `id` int(11) NOT NULL,
  `usuario` char(20) NOT NULL,
  `password` char(64) NOT NULL,
  `correo` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `gestor`
--

INSERT INTO `gestor` (`id`, `usuario`, `password`, `correo`) VALUES
(1, 'Yoely', 'yoely', 'yoely@'),
(2, 'prueba', 'prueba', 'prueba'),
(3, 'gestor', 'gestor', 'gestor'),
(4, 'aaa', 'aaa', 'aaa@'),
(5, 'bbb', 'bbb', 'bbb@'),
(6, 'ccc', 'ccc', 'ccc@'),
(7, 'ddd', 'ddd', 'ddd@'),
(8, 'eee', 'eee', 'eee@'),
(9, 'fff', 'fff', 'fff@');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `id` int(11) NOT NULL,
  `id_origen` int(11) NOT NULL,
  `id_destino` int(11) NOT NULL,
  `texto` char(140) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`id`, `id_origen`, `id_destino`, `texto`, `fecha`) VALUES
(4, 1, 2, 'texto', '2022-11-10 16:00:41'),
(5, 2, 1, 'prueba', '2022-11-10 16:02:50'),
(6, 1, 2, 'ggg', '2022-11-10 16:03:07'),
(8, 1, 2, '', '2022-11-10 16:16:48'),
(9, 1, 2, 'mensaje largo de prueba', '2022-11-10 16:17:35');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id` int(11) NOT NULL,
  `nombre` char(20) NOT NULL,
  `comision` double NOT NULL,
  `meses` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo_relacion`
--

CREATE TABLE `prestamo_relacion` (
  `id_prestamo` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transferencia`
--

CREATE TABLE `transferencia` (
  `id` int(11) NOT NULL,
  `id_ordenante` int(11) NOT NULL,
  `id_beneficiario` int(11) NOT NULL,
  `importe` double NOT NULL,
  `concepto` varchar(40) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `transferencia`
--

INSERT INTO `transferencia` (`id`, `id_ordenante`, `id_beneficiario`, `importe`, `concepto`, `fecha`) VALUES
(3, 1, 2, 12, 'concepto', '2022-11-10 16:04:10'),
(4, 2, 1, 32, 'prueba', '2022-11-10 16:05:58');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_gestor` (`id_gestor`);

--
-- Indices de la tabla `gestor`
--
ALTER TABLE `gestor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_destino` (`id_destino`),
  ADD KEY `id_origen` (`id_origen`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `prestamo_relacion`
--
ALTER TABLE `prestamo_relacion`
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_prestamo` (`id_prestamo`);

--
-- Indices de la tabla `transferencia`
--
ALTER TABLE `transferencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_beneficiario` (`id_beneficiario`),
  ADD KEY `id_ordenante` (`id_ordenante`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `gestor`
--
ALTER TABLE `gestor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `transferencia`
--
ALTER TABLE `transferencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_gestor`) REFERENCES `gestor` (`id`);

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `mensaje_ibfk_1` FOREIGN KEY (`id_destino`) REFERENCES `gestor` (`id`),
  ADD CONSTRAINT `mensaje_ibfk_2` FOREIGN KEY (`id_origen`) REFERENCES `gestor` (`id`);

--
-- Filtros para la tabla `prestamo_relacion`
--
ALTER TABLE `prestamo_relacion`
  ADD CONSTRAINT `prestamo_relacion_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `prestamo_relacion_ibfk_2` FOREIGN KEY (`id_prestamo`) REFERENCES `prestamo` (`id`);

--
-- Filtros para la tabla `transferencia`
--
ALTER TABLE `transferencia`
  ADD CONSTRAINT `transferencia_ibfk_1` FOREIGN KEY (`id_beneficiario`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `transferencia_ibfk_2` FOREIGN KEY (`id_ordenante`) REFERENCES `cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
