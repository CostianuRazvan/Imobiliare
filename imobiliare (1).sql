-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 08, 2017 at 07:45 PM
-- Server version: 10.1.24-MariaDB
-- PHP Version: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `imobiliare`
--

-- --------------------------------------------------------

--
-- Table structure for table `aptinchiriere`
--

CREATE TABLE `aptinchiriere` (
  `OIA` int(11) NOT NULL,
  `Zona` varchar(20) NOT NULL,
  `Pozitie` varchar(20) NOT NULL,
  `Camere` varchar(20) NOT NULL,
  `Metrou` int(3) NOT NULL,
  `Confort` varchar(20) NOT NULL,
  `Mobila` varchar(20) NOT NULL,
  `Bucatarie` varchar(20) NOT NULL,
  `ImbunatatiriReale` varchar(20) NOT NULL,
  `EtajeTotale` int(4) NOT NULL,
  `Etaj` int(3) NOT NULL,
  `Agent` varchar(20) NOT NULL,
  `AnConstructie` int(4) NOT NULL,
  `Imagine` tinyint(1) NOT NULL,
  `Publicate` tinyint(1) NOT NULL,
  `Web` varchar(20) NOT NULL,
  `Stare` varchar(20) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `ClientID` int(12) NOT NULL,
  `Comision` varchar(5) NOT NULL,
  `Negociabil` int(2) NOT NULL,
  `Pret` int(10) NOT NULL,
  `Exclusivitate` int(2) NOT NULL,
  `ObservatiiPret` varchar(500) NOT NULL,
  `Textanunt` varchar(500) NOT NULL,
  `AlteDetaliiConfidentiale` varchar(500) NOT NULL,
  `Sector` varchar(50) NOT NULL,
  `Strada` varchar(50) NOT NULL,
  `Numar` int(10) NOT NULL,
  `Reper` varchar(50) NOT NULL,
  `AdresaCompleta` varchar(500) NOT NULL,
  `SuprafataConstruita` int(10) NOT NULL,
  `NumarGrupuriSanitare` int(10) NOT NULL,
  `NumarBalcoane` int(5) NOT NULL,
  `SuprafataUtila` int(10) NOT NULL,
  `FereastraGrupSanitar` int(3) NOT NULL,
  `NumarGaraje` int(2) NOT NULL,
  `LocuriParcare` int(5) NOT NULL,
  `Rezidential` int(2) NOT NULL,
  `Comercial` int(3) NOT NULL,
  `Birouri` int(2) NOT NULL,
  `Vacanta` int(2) NOT NULL,
  `UsiIntrare` varchar(50) NOT NULL,
  `Celulare` int(3) NOT NULL,
  `Lemn` int(3) NOT NULL,
  `Panel` int(3) NOT NULL,
  `PVC` int(2) NOT NULL,
  `Sticla` int(2) NOT NULL,
  `DescriereEmotionala` varchar(500) NOT NULL,
  `Link` varchar(100) NOT NULL,
  `Harta` longblob,
  `Poza` longblob,
  `Parter` tinyint(1) DEFAULT NULL,
  `Ultimul` tinyint(1) DEFAULT NULL,
  `Data` datetime(6) NOT NULL,
  `Compartimentare` varchar(50) NOT NULL,
  `Curent` int(3) NOT NULL,
  `Gaz` int(3) NOT NULL,
  `Apa` int(3) NOT NULL,
  `Canalizare` int(3) NOT NULL,
  `Catv` int(3) NOT NULL,
  `TelefonO` int(11) NOT NULL,
  `International` int(3) NOT NULL,
  `CentralaProprie` int(11) NOT NULL,
  `CentralaImobil` int(3) NOT NULL,
  `Termoficare` int(3) NOT NULL,
  `Soba` int(3) NOT NULL,
  `Calorifere` int(3) NOT NULL,
  `IncalzirePardoseala` int(3) NOT NULL,
  `Cablu` int(3) NOT NULL,
  `FibraOptica` int(3) NOT NULL,
  `Wireless` int(3) NOT NULL,
  `Adsl` int(11) NOT NULL,
  `Parchet` int(3) NOT NULL,
  `Gresie` int(3) NOT NULL,
  `Linoleum` int(3) NOT NULL,
  `Mocheta` int(3) NOT NULL,
  `Dusumea` int(3) NOT NULL,
  `Marmura` int(3) NOT NULL,
  `Var` int(3) NOT NULL,
  `Vinarom` int(3) NOT NULL,
  `Lavabila` int(3) NOT NULL,
  `Faianta` int(3) NOT NULL,
  `Lambriu` int(3) NOT NULL,
  `Tapet` int(3) NOT NULL,
  `Homa` int(3) NOT NULL,
  `Aluminiu` int(3) NOT NULL,
  `Pvc2` int(3) NOT NULL,
  `Lemn2` int(3) NOT NULL,
  `Interior` int(3) NOT NULL,
  `Exterior` int(3) NOT NULL,
  `Terasa` int(3) NOT NULL,
  `WCServiciu` int(11) NOT NULL,
  `Debara` int(3) NOT NULL,
  `BoxaSubsol` int(11) NOT NULL,
  `Apometre` int(3) NOT NULL,
  `ContorGaz` int(3) NOT NULL,
  `ContoareCaldura` int(3) NOT NULL,
  `Jacuzzi` int(3) NOT NULL,
  `SenzorFum` int(3) NOT NULL,
  `Alarma` int(3) NOT NULL,
  `Aragaz` int(3) NOT NULL,
  `CuptorMicrounde` int(3) NOT NULL,
  `Plita` int(3) NOT NULL,
  `MasinaDeSpalat` int(3) NOT NULL,
  `Lift` int(3) NOT NULL,
  `Interfon` int(3) NOT NULL,
  `Sauna` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `aptvanzare`
--

CREATE TABLE `aptvanzare` (
  `OVA` int(11) NOT NULL,
  `Zona` varchar(20) NOT NULL,
  `Pozitie` varchar(20) NOT NULL,
  `Camere` varchar(20) NOT NULL,
  `Metrou` int(3) NOT NULL,
  `Confort` varchar(20) NOT NULL,
  `Mobila` varchar(20) NOT NULL,
  `Bucatarie` varchar(20) NOT NULL,
  `ImbunatatiriReale` varchar(20) NOT NULL,
  `EtajeTotale` int(4) NOT NULL,
  `Etaj` int(3) NOT NULL,
  `Agent` varchar(20) NOT NULL,
  `AnConstructie` int(4) NOT NULL,
  `Imagine` tinyint(1) NOT NULL,
  `Publicate` tinyint(1) NOT NULL,
  `Web` varchar(20) NOT NULL,
  `Stare` varchar(20) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `ClientID` int(12) NOT NULL,
  `Comision` varchar(5) NOT NULL,
  `Negociabil` int(2) NOT NULL,
  `Pret` int(10) NOT NULL,
  `Exclusivitate` int(2) NOT NULL,
  `ObservatiiPret` varchar(500) NOT NULL,
  `Textanunt` varchar(500) NOT NULL,
  `AlteDetaliiConfidentiale` varchar(500) NOT NULL,
  `Sector` varchar(50) NOT NULL,
  `Strada` varchar(50) NOT NULL,
  `Numar` int(10) NOT NULL,
  `Reper` varchar(50) NOT NULL,
  `AdresaCompleta` varchar(500) NOT NULL,
  `SuprafataConstruita` int(10) NOT NULL,
  `NumarGrupuriSanitare` int(10) NOT NULL,
  `NumarBalcoane` int(5) NOT NULL,
  `SuprafataUtila` int(10) NOT NULL,
  `FereastraGrupSanitar` int(3) NOT NULL,
  `NumarGaraje` int(2) NOT NULL,
  `LocuriParcare` int(5) NOT NULL,
  `Rezidential` int(2) NOT NULL,
  `Comercial` int(3) NOT NULL,
  `Birouri` int(2) NOT NULL,
  `Vacanta` int(2) NOT NULL,
  `UsiIntrare` varchar(50) NOT NULL,
  `Celulare` int(3) NOT NULL,
  `Lemn` int(3) NOT NULL,
  `Panel` int(3) NOT NULL,
  `PVC` int(2) NOT NULL,
  `Sticla` int(2) NOT NULL,
  `DescriereEmotionala` varchar(500) NOT NULL,
  `Link` varchar(100) NOT NULL,
  `Harta` longblob,
  `Poza` longblob,
  `Parter` tinyint(1) DEFAULT NULL,
  `Ultimul` tinyint(1) DEFAULT NULL,
  `Data` datetime NOT NULL,
  `Compartimentare` varchar(50) NOT NULL,
  `Curent` int(3) NOT NULL,
  `Gaz` int(3) NOT NULL,
  `Apa` int(3) NOT NULL,
  `Canalizare` int(3) NOT NULL,
  `Catv` int(3) NOT NULL,
  `TelefonO` int(11) NOT NULL,
  `International` int(3) NOT NULL,
  `CentralaProprie` int(11) NOT NULL,
  `CentralaImobil` int(3) NOT NULL,
  `Termoficare` int(3) NOT NULL,
  `Soba` int(3) NOT NULL,
  `Calorifere` int(3) NOT NULL,
  `IncalzirePardoseala` int(3) NOT NULL,
  `Cablu` int(3) NOT NULL,
  `FibraOptica` int(3) NOT NULL,
  `Wireless` int(3) NOT NULL,
  `Adsl` int(11) NOT NULL,
  `Parchet` int(3) NOT NULL,
  `Gresie` int(3) NOT NULL,
  `Linoleum` int(3) NOT NULL,
  `Mocheta` int(3) NOT NULL,
  `Dusumea` int(3) NOT NULL,
  `Marmura` int(3) NOT NULL,
  `Var` int(3) NOT NULL,
  `Vinarom` int(3) NOT NULL,
  `Lavabila` int(3) NOT NULL,
  `Faianta` int(3) NOT NULL,
  `Lambriu` int(3) NOT NULL,
  `Tapet` int(3) NOT NULL,
  `Homa` int(3) NOT NULL,
  `Aluminiu` int(3) NOT NULL,
  `Pvc2` int(3) NOT NULL,
  `Lemn2` int(3) NOT NULL,
  `Interior` int(3) NOT NULL,
  `Exterior` int(3) NOT NULL,
  `Terasa` int(3) NOT NULL,
  `WCServiciu` int(11) NOT NULL,
  `Debara` int(3) NOT NULL,
  `BoxaSubsol` int(11) NOT NULL,
  `Apometre` int(3) NOT NULL,
  `ContorGaz` int(3) NOT NULL,
  `ContoareCaldura` int(3) NOT NULL,
  `Jacuzzi` int(3) NOT NULL,
  `SenzorFum` int(3) NOT NULL,
  `Alarma` int(3) NOT NULL,
  `Aragaz` int(3) NOT NULL,
  `CuptorMicrounde` int(3) NOT NULL,
  `Plita` int(3) NOT NULL,
  `MasinaDeSpalat` int(3) NOT NULL,
  `Lift` int(3) NOT NULL,
  `Interfon` int(3) NOT NULL,
  `Sauna` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `casevileinchiriere`
--

CREATE TABLE `casevileinchiriere` (
  `OIC` int(12) NOT NULL,
  `Zona` varchar(20) NOT NULL,
  `Pozitie` varchar(20) NOT NULL,
  `Destinatie` varchar(20) NOT NULL,
  `Pret` int(10) NOT NULL,
  `Camere` int(3) NOT NULL,
  `Parcari` int(5) NOT NULL,
  `Metrou` tinyint(1) NOT NULL,
  `ImbunatatiriReale` varchar(20) NOT NULL,
  `SuprafataConstructie` int(10) NOT NULL,
  `SuprafataTeren` int(10) NOT NULL,
  `Agenti` varchar(20) NOT NULL,
  `AnConstructie` int(4) NOT NULL,
  `Imagine` tinyint(1) NOT NULL,
  `Publicate` tinyint(1) NOT NULL,
  `Web` varchar(20) NOT NULL,
  `Stare` varchar(15) NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `casevilevanzare`
--

CREATE TABLE `casevilevanzare` (
  `OIC` int(12) NOT NULL,
  `Zona` varchar(20) NOT NULL,
  `Pozitie` varchar(20) NOT NULL,
  `Destinatie` varchar(20) NOT NULL,
  `Pret` int(10) NOT NULL,
  `Camere` int(3) NOT NULL,
  `Parcari` int(5) NOT NULL,
  `Metrou` tinyint(1) NOT NULL,
  `ImbunatatiriReale` varchar(20) NOT NULL,
  `SuprafataConstructie` int(10) NOT NULL,
  `SuprafataTeren` int(10) NOT NULL,
  `Agenti` varchar(20) NOT NULL,
  `AnConstructie` int(4) NOT NULL,
  `Imagine` tinyint(1) NOT NULL,
  `Publicate` tinyint(1) NOT NULL,
  `Web` varchar(20) NOT NULL,
  `Stare` varchar(15) NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `cerereca`
--

CREATE TABLE `cerereca` (
  `CCA` int(10) NOT NULL,
  `ClientID` int(10) NOT NULL,
  `Pret` int(10) NOT NULL,
  `Comision` varchar(5) NOT NULL,
  `Exclusivitate` int(3) NOT NULL,
  `Negociabil` int(3) NOT NULL,
  `ObservatiiPret` text NOT NULL,
  `TextAnuntIntern` text NOT NULL,
  `AlteDetalii` text NOT NULL,
  `Sector` varchar(20) NOT NULL,
  `Zona` varchar(300) NOT NULL,
  `Metrou` int(3) NOT NULL,
  `Garsoniera` int(3) NOT NULL,
  `2camere` int(3) NOT NULL,
  `3camere` int(3) NOT NULL,
  `4camere` int(3) NOT NULL,
  `4camerep` int(3) NOT NULL,
  `I` int(3) NOT NULL,
  `Ip` int(3) NOT NULL,
  `II` int(3) NOT NULL,
  `IIp` int(3) NOT NULL,
  `III` int(3) NOT NULL,
  `IIIp` int(3) NOT NULL,
  `Semidecomandat` int(3) NOT NULL,
  `Decomandat` int(3) NOT NULL,
  `Circular` int(3) NOT NULL,
  `Etaj1` int(3) NOT NULL,
  `Etaj2` int(3) NOT NULL,
  `Parter` int(3) NOT NULL,
  `Ultimul` int(3) NOT NULL,
  `Observatii` text NOT NULL,
  `Stare` varchar(20) NOT NULL,
  `Data` datetime NOT NULL,
  `Agent` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `cerereia`
--

CREATE TABLE `cerereia` (
  `CIA` int(10) NOT NULL,
  `ClientID` int(10) NOT NULL,
  `Pret` int(10) NOT NULL,
  `Comision` varchar(5) NOT NULL,
  `Exclusivitate` int(3) NOT NULL,
  `Negociabil` int(3) NOT NULL,
  `ObservatiiPret` text NOT NULL,
  `TextAnuntIntern` text NOT NULL,
  `AlteDetalii` text NOT NULL,
  `Sector` varchar(20) NOT NULL,
  `Zona` varchar(300) NOT NULL,
  `Metrou` int(3) NOT NULL,
  `Garsoniera` int(3) NOT NULL,
  `2camere` int(3) NOT NULL,
  `3camere` int(3) NOT NULL,
  `4camere` int(3) NOT NULL,
  `4camerep` int(3) NOT NULL,
  `I` int(3) NOT NULL,
  `Ip` int(3) NOT NULL,
  `II` int(3) NOT NULL,
  `IIp` int(3) NOT NULL,
  `III` int(3) NOT NULL,
  `IIIp` int(3) NOT NULL,
  `Semidecomandat` int(3) NOT NULL,
  `Decomandat` int(3) NOT NULL,
  `Circular` int(3) NOT NULL,
  `Etaj1` int(3) NOT NULL,
  `Etaj2` int(3) NOT NULL,
  `Parter` int(3) NOT NULL,
  `Ultimul` int(3) NOT NULL,
  `Observatii` text NOT NULL,
  `Stare` varchar(20) NOT NULL,
  `Data` datetime NOT NULL,
  `Agent` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `clienti`
--

CREATE TABLE `clienti` (
  `ID` int(20) NOT NULL,
  `Nume` varchar(50) DEFAULT NULL,
  `Prenume` varchar(50) DEFAULT NULL,
  `Telefon` int(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `AgentID` int(11) DEFAULT NULL,
  `NumeAgent` varchar(24) DEFAULT NULL,
  `Observatii` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `comentariica`
--

CREATE TABLE `comentariica` (
  `ID` int(10) NOT NULL,
  `Cod` int(20) NOT NULL,
  `Comentarii` varchar(500) NOT NULL,
  `Agent` varchar(50) NOT NULL,
  `DataOra` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `comentariicia`
--

CREATE TABLE `comentariicia` (
  `ID` int(20) NOT NULL,
  `Cod` int(20) NOT NULL,
  `Comentarii` varchar(500) NOT NULL,
  `Agent` varchar(50) NOT NULL,
  `DataOra` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `comentariiia`
--

CREATE TABLE `comentariiia` (
  `ID` int(40) NOT NULL,
  `Cod` int(10) NOT NULL,
  `Comentarii` varchar(200) NOT NULL,
  `Agent` varchar(30) NOT NULL,
  `DataOra` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `comentariiva`
--

CREATE TABLE `comentariiva` (
  `ID` int(40) NOT NULL,
  `Cod` int(10) NOT NULL,
  `Comentarii` varchar(200) NOT NULL,
  `Agent` varchar(30) NOT NULL,
  `DataOra` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `pozavc`
--

CREATE TABLE `pozavc` (
  `ID_Poza` int(12) NOT NULL,
  `OVC` int(12) NOT NULL,
  `Poza` longblob NOT NULL,
  `PrimaPoza` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `pozeia`
--

CREATE TABLE `pozeia` (
  `ID_Poza` int(12) NOT NULL,
  `OIA` int(12) NOT NULL,
  `Poza` longblob NOT NULL,
  `PrimaPoza` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `pozeic`
--

CREATE TABLE `pozeic` (
  `ID_Poza` int(12) NOT NULL,
  `OIC` int(12) NOT NULL,
  `Poza` longblob NOT NULL,
  `PrimaPoza` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `pozeva`
--

CREATE TABLE `pozeva` (
  `ID_Poza` int(11) NOT NULL,
  `OVA` int(11) NOT NULL,
  `Poza` longblob NOT NULL,
  `PrimaPoza` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserName` varchar(12) NOT NULL,
  `Password` varchar(12) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserName`, `Password`, `ID`) VALUES
('CostianuR', 'costi', 1),
('zarnea', 'munteanu', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aptinchiriere`
--
ALTER TABLE `aptinchiriere`
  ADD PRIMARY KEY (`OIA`);

--
-- Indexes for table `aptvanzare`
--
ALTER TABLE `aptvanzare`
  ADD PRIMARY KEY (`OVA`);

--
-- Indexes for table `casevileinchiriere`
--
ALTER TABLE `casevileinchiriere`
  ADD PRIMARY KEY (`OIC`);

--
-- Indexes for table `casevilevanzare`
--
ALTER TABLE `casevilevanzare`
  ADD PRIMARY KEY (`OIC`);

--
-- Indexes for table `cerereca`
--
ALTER TABLE `cerereca`
  ADD PRIMARY KEY (`CCA`);

--
-- Indexes for table `cerereia`
--
ALTER TABLE `cerereia`
  ADD PRIMARY KEY (`CIA`);

--
-- Indexes for table `clienti`
--
ALTER TABLE `clienti`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `comentariica`
--
ALTER TABLE `comentariica`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `comentariicia`
--
ALTER TABLE `comentariicia`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `comentariiia`
--
ALTER TABLE `comentariiia`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `comentariiva`
--
ALTER TABLE `comentariiva`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `pozavc`
--
ALTER TABLE `pozavc`
  ADD PRIMARY KEY (`ID_Poza`);

--
-- Indexes for table `pozeia`
--
ALTER TABLE `pozeia`
  ADD PRIMARY KEY (`ID_Poza`);

--
-- Indexes for table `pozeic`
--
ALTER TABLE `pozeic`
  ADD PRIMARY KEY (`ID_Poza`);

--
-- Indexes for table `pozeva`
--
ALTER TABLE `pozeva`
  ADD PRIMARY KEY (`ID_Poza`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aptinchiriere`
--
ALTER TABLE `aptinchiriere`
  MODIFY `OIA` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `aptvanzare`
--
ALTER TABLE `aptvanzare`
  MODIFY `OVA` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `casevileinchiriere`
--
ALTER TABLE `casevileinchiriere`
  MODIFY `OIC` int(12) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `casevilevanzare`
--
ALTER TABLE `casevilevanzare`
  MODIFY `OIC` int(12) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cerereca`
--
ALTER TABLE `cerereca`
  MODIFY `CCA` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cerereia`
--
ALTER TABLE `cerereia`
  MODIFY `CIA` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `clienti`
--
ALTER TABLE `clienti`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comentariica`
--
ALTER TABLE `comentariica`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comentariicia`
--
ALTER TABLE `comentariicia`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comentariiia`
--
ALTER TABLE `comentariiia`
  MODIFY `ID` int(40) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comentariiva`
--
ALTER TABLE `comentariiva`
  MODIFY `ID` int(40) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pozavc`
--
ALTER TABLE `pozavc`
  MODIFY `ID_Poza` int(12) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pozeia`
--
ALTER TABLE `pozeia`
  MODIFY `ID_Poza` int(12) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pozeic`
--
ALTER TABLE `pozeic`
  MODIFY `ID_Poza` int(12) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pozeva`
--
ALTER TABLE `pozeva`
  MODIFY `ID_Poza` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
