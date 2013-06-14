
CREATE TABLE `pp_degrees` (
  `DEGREE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEGREE_NAME` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`DEGREE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$


CREATE TABLE `pp_phisician` (
  `PHSICIAN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PHSICIAN_NAME` varchar(100) DEFAULT NULL,
  `PHSICIAN_RESIDENCE_ADDRESS_ID` int(11) DEFAULT NULL,
  `PHSICIAN_OFFICE_ADDRESS_ID` int(11) DEFAULT NULL,
  `PHSICIAN_AGE` int(11) DEFAULT NULL,
  `PHSICIAN_GENDER` varchar(1) DEFAULT NULL,
  `PHSICIAN_DOB` varchar(20) DEFAULT NULL,
  `EMAIL_ADDRESS` varchar(100) DEFAULT NULL,
  `RESIDENCE_LAND_PHONE` varchar(45) DEFAULT NULL,
  `OFFCE_LAND_PHONE` varchar(45) DEFAULT NULL,
  `CELL_PHONE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PHSICIAN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8$$


CREATE TABLE `pp_phsician_address` (
  `ADDRESS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `HOUSE_NUMBER` varchar(45) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `STATE` varchar(2) DEFAULT NULL,
  `ZIP` varchar(45) DEFAULT NULL,
  `COUNTRY` varchar(45) DEFAULT NULL,
  `ADDRESS_TYPE` varchar(45) DEFAULT NULL,
  `physician_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8$$


CREATE TABLE `pp_physician_degrees` (
  `PHSICIAN_ID` int(11) NOT NULL,
  `DEGREE_ID` int(11) DEFAULT NULL,
  `YEAR_PASSED` int(11) DEFAULT NULL,
  `PERCENTAGE` float DEFAULT NULL,
  `physician_dg_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`physician_dg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$




CREATE TABLE `pp_physician_degrees` (
  `PHSICIAN_ID` int(11) NOT NULL,
  `DEGREE_ID` int(11) DEFAULT NULL,
  `YEAR_PASSED` int(11) DEFAULT NULL,
  `PERCENTAGE` float DEFAULT NULL,
  `physician_dg_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`physician_dg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8$$


CREATE TABLE `pp_physician_speciality` (
  `PHSICIAN_ID` int(11) NOT NULL,
  `SPECIALITY_ID` varchar(45) DEFAULT NULL,
  `RANK` varchar(45) DEFAULT NULL,
  `PP_SPECIALITY_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`PP_SPECIALITY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8$$


Sample Daata for `pp_speciality`

'1', 'Allergy & Immunology'
'2', 'Anesthesiology'
'3', 'Cardiovascular Disease'
'4', 'Dermatology'
'5', 'Emergency Medicine'
'6', 'Family Medicine/General Practice'
'7', 'Gastroenterology'
'8', 'General Surgery'
'9', 'Hematology & OncologyInfectious Disease'
'10', 'Infectious Disease'
'11', 'Internal MedicineNephrology'
'12', 'NephrologyNeurology'
'13', 'Neurology'
'14', 'Obstetrics & Gynecology'
'15', 'Pediatrics'

Sample Daata for `pp_degrees`



'1', 'Doctor of Medicine(M.D.)'

Spring Batch Related Table

CREATE TABLE `batch_job_execution` (
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `VERSION` bigint(20) DEFAULT NULL,
  `JOB_INSTANCE_ID` bigint(20) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `END_TIME` datetime DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `EXIT_CODE` varchar(100) DEFAULT NULL,
  `EXIT_MESSAGE` varchar(2500) DEFAULT NULL,
  `LAST_UPDATED` datetime DEFAULT NULL,
  PRIMARY KEY (`JOB_EXECUTION_ID`),
  KEY `JOB_INST_EXEC_FK` (`JOB_INSTANCE_ID`),
  CONSTRAINT `JOB_INST_EXEC_FK` FOREIGN KEY (`JOB_INSTANCE_ID`) REFERENCES `batch_job_instance` (`JOB_INSTANCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$



CREATE TABLE `batch_job_execution_context` (
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `SHORT_CONTEXT` varchar(2500) NOT NULL,
  `SERIALIZED_CONTEXT` text,
  PRIMARY KEY (`JOB_EXECUTION_ID`),
  CONSTRAINT `JOB_EXEC_CTX_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `batch_job_execution` (`JOB_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


CREATE TABLE `batch_job_execution_seq` (
  `ID` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

CREATE TABLE `batch_job_instance` (
  `JOB_INSTANCE_ID` bigint(20) NOT NULL,
  `VERSION` bigint(20) DEFAULT NULL,
  `JOB_NAME` varchar(100) NOT NULL,
  `JOB_KEY` varchar(32) NOT NULL,
  PRIMARY KEY (`JOB_INSTANCE_ID`),
  UNIQUE KEY `JOB_INST_UN` (`JOB_NAME`,`JOB_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


CREATE TABLE `batch_job_params` (
  `JOB_INSTANCE_ID` bigint(20) NOT NULL,
  `TYPE_CD` varchar(6) NOT NULL,
  `KEY_NAME` varchar(100) NOT NULL,
  `STRING_VAL` varchar(250) DEFAULT NULL,
  `DATE_VAL` datetime DEFAULT NULL,
  `LONG_VAL` bigint(20) DEFAULT NULL,
  `DOUBLE_VAL` double DEFAULT NULL,
  KEY `JOB_INST_PARAMS_FK` (`JOB_INSTANCE_ID`),
  CONSTRAINT `JOB_INST_PARAMS_FK` FOREIGN KEY (`JOB_INSTANCE_ID`) REFERENCES `batch_job_instance` (`JOB_INSTANCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

CREATE TABLE `batch_job_seq` (
  `ID` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$

CREATE TABLE `batch_step_execution` (
  `STEP_EXECUTION_ID` bigint(20) NOT NULL,
  `VERSION` bigint(20) NOT NULL,
  `STEP_NAME` varchar(100) NOT NULL,
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `START_TIME` datetime NOT NULL,
  `END_TIME` datetime DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `COMMIT_COUNT` bigint(20) DEFAULT NULL,
  `READ_COUNT` bigint(20) DEFAULT NULL,
  `FILTER_COUNT` bigint(20) DEFAULT NULL,
  `WRITE_COUNT` bigint(20) DEFAULT NULL,
  `READ_SKIP_COUNT` bigint(20) DEFAULT NULL,
  `WRITE_SKIP_COUNT` bigint(20) DEFAULT NULL,
  `PROCESS_SKIP_COUNT` bigint(20) DEFAULT NULL,
  `ROLLBACK_COUNT` bigint(20) DEFAULT NULL,
  `EXIT_CODE` varchar(100) DEFAULT NULL,
  `EXIT_MESSAGE` varchar(2500) DEFAULT NULL,
  `LAST_UPDATED` datetime DEFAULT NULL,
  PRIMARY KEY (`STEP_EXECUTION_ID`),
  KEY `JOB_EXEC_STEP_FK` (`JOB_EXECUTION_ID`),
  CONSTRAINT `JOB_EXEC_STEP_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `batch_job_execution` (`JOB_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

CREATE TABLE `batch_step_execution_context` (
  `STEP_EXECUTION_ID` bigint(20) NOT NULL,
  `SHORT_CONTEXT` varchar(2500) NOT NULL,
  `SERIALIZED_CONTEXT` text,
  PRIMARY KEY (`STEP_EXECUTION_ID`),
  CONSTRAINT `STEP_EXEC_CTX_FK` FOREIGN KEY (`STEP_EXECUTION_ID`) REFERENCES `batch_step_execution` (`STEP_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

CREATE TABLE `batch_step_execution_seq` (
  `ID` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8$$


