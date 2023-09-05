-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: accessmanagement
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_config` (
  `config_id` int NOT NULL AUTO_INCREMENT,
  `config_name` varchar(100) DEFAULT '',
  `config_key` varchar(100) DEFAULT '',
  `config_value` varchar(100) DEFAULT '',
  `config_type` varchar(1) DEFAULT 'N' COMMENT 'build-in settings (Y or N)',
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT '',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES (1,'Main frame page - default skin style name','sys.index.skinName','skin-default','Y','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','Default skin-default、blue skin-blue、yellow skin-yellow'),(2,'User Management-Account Initial Password','sys.user.initPassword','123456','Y','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','init password 123456');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dept` (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `parent_id` int DEFAULT '0',
  `dept_name` varchar(30) DEFAULT '',
  `order_num` int DEFAULT '0' COMMENT 'display order',
  `leader` varchar(20) DEFAULT '',
  `phone` varchar(11) DEFAULT '',
  `email` varchar(50) DEFAULT '',
  `status` varchar(1) DEFAULT '0' COMMENT '0 normal 1 stop',
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (100,0,'CDRCB',0,'GS','15888888888','felix@gmail.com','0','admin','2023-08-30 11:33:00','Felix','2023-08-30 11:33:00'),(101,100,'Development',1,'GS','15888888888','felix@gmail.com','0','admin','2023-08-30 11:33:00','Felix','2023-08-30 11:33:00'),(102,100,'Market',2,'GS','15888888888','felix@gmail.com','0','admin','2023-08-30 11:33:00','Felix','2023-08-30 11:33:00');
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_data`
--

DROP TABLE IF EXISTS `sys_dict_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_data` (
  `dict_code` int NOT NULL AUTO_INCREMENT,
  `dict_sort` int DEFAULT '0',
  `dict_label` varchar(100) DEFAULT '',
  `dict_value` varchar(100) DEFAULT '',
  `dict_type` varchar(100) DEFAULT '',
  `css_class` varchar(500) DEFAULT '',
  `is_default` varchar(1) DEFAULT 'N' COMMENT 'Y or N',
  `status` varchar(1) DEFAULT '0' COMMENT '0-normal 1-stop',
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT '',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_data`
--

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;
INSERT INTO `sys_dict_data` VALUES (1,1,'male','0','sys_user_sex','','Y','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','male'),(2,2,'female','1','sys_user_sex','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','female'),(3,3,'unknown','2','sys_user_sex','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','unknown'),(4,1,'display','0','sys_show_hide','radio radio-info radio-inline','Y','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','display menu'),(5,2,'hide','1','sys_show_hide','radio radio-danger radio-inline','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','hide menu'),(6,1,'normal','0','sys_normal_disable','radio radio-info radio-inline','Y','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','provide service'),(7,2,'stop','1','sys_normal_disable','radio radio-danger radio-inline','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','not provide service'),(8,1,'normalstatus','0','sys_job_status','radio radio-info radio-inline','Y','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','normalstatus'),(9,2,'pausestatus','1','sys_job_status','radio radio-danger radio-inline','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','pausestatus'),(10,1,'yes','Y','sys_yes_no','radio radio-info radio-inline','Y','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','default yes'),(11,2,'no','N','sys_yes_no','radio radio-danger radio-inline','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','default no'),(12,1,'notice','1','sys_notice_type','','Y','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','notice'),(13,2,'proclaim','2','sys_notice_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','proclaim'),(14,1,'StatusOn','0','sys_notice_status','radio radio-info radio-inline','Y','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','StatusOn'),(15,2,'StatusClose','1','sys_notice_status','radio radio-danger radio-inline','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','StatusClose'),(16,1,'Add','1','sys_oper_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','AddOperation'),(17,2,'Modify','2','sys_oper_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','ModifyOperation'),(18,3,'Save','3','sys_oper_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','SaveOperation'),(19,4,'Delete','4','sys_oper_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','DeleteOperation'),(20,5,'Grant','5','sys_oper_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','GrantOperation'),(21,6,'Export','6','sys_oper_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','ExportOperation'),(22,7,'Import','7','sys_oper_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','ImportOperation'),(23,8,'ForceExit','8','sys_oper_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','ForceExitOperation'),(24,9,'ProhabitedAccess','9','sys_oper_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','ProhabitedAccessOperation'),(25,10,'GenerateCode','10','sys_oper_type','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','GenerateCodeOperation'),(26,1,'Success','0','sys_common_status','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','SuccessStatus'),(27,2,'Failure','1','sys_common_status','','N','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','FailureStatus');
/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_type`
--

DROP TABLE IF EXISTS `sys_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_type` (
  `dict_id` int NOT NULL AUTO_INCREMENT,
  `dict_name` varchar(100) DEFAULT '',
  `dict_type` varchar(100) DEFAULT '',
  `status` varchar(1) DEFAULT '0' COMMENT '0 normal 1 stop',
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT '',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_type`
--

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;
INSERT INTO `sys_dict_type` VALUES (1,'UserGenderType','sys_user_sex','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','UserGenderTypeLIst'),(2,'MenuStatus','sys_show_hide','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','MenuStatusList'),(3,'SystemSwitch','sys_normal_disable','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','SystemSwitchList'),(4,'TaskStatus','sys_job_status','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','TaskStatusList'),(5,'SystemBooleanFlag','sys_yes_no','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','SystemBooleanFlagList'),(6,'NoticeType','sys_notice_type','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','NoticeTypeList'),(7,'NoticeStatus','sys_notice_status','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','NoticeStatusList'),(8,'OperationType','sys_oper_type','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','OperationTypeList'),(9,'SystemStatus','sys_common_status','0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','SystemStatusList');
/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job`
--

DROP TABLE IF EXISTS `sys_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_job` (
  `job_id` int NOT NULL AUTO_INCREMENT,
  `job_name` varchar(64) NOT NULL DEFAULT '',
  `job_group` varchar(64) NOT NULL DEFAULT '',
  `method_name` varchar(500) DEFAULT '',
  `params` varchar(200) DEFAULT '',
  `cron_expression` varchar(255) DEFAULT '',
  `status` varchar(1) DEFAULT '0',
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT '',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job`
--

LOCK TABLES `sys_job` WRITE;
/*!40000 ALTER TABLE `sys_job` DISABLE KEYS */;
INSERT INTO `sys_job` VALUES (1,'ryTask','Default(no param)','ryNoParams','','0/10 * * * * ?','1','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(2,'ryTask','Default(with param)','ryParams','ry','0/20 * * * * ?','1','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','');
/*!40000 ALTER TABLE `sys_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job_log`
--

DROP TABLE IF EXISTS `sys_job_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_job_log` (
  `job_log_id` int NOT NULL AUTO_INCREMENT,
  `job_name` varchar(64) NOT NULL,
  `job_group` varchar(64) NOT NULL,
  `method_name` varchar(500) DEFAULT NULL,
  `params` varchar(200) DEFAULT '',
  `job_message` varchar(500) DEFAULT NULL,
  `status` varchar(1) DEFAULT '0',
  `exception_info` text,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job_log`
--

LOCK TABLES `sys_job_log` WRITE;
/*!40000 ALTER TABLE `sys_job_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_job_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_logininfor`
--

DROP TABLE IF EXISTS `sys_logininfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_logininfor` (
  `info_id` int NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) DEFAULT '',
  `ipaddr` varchar(50) DEFAULT '',
  `login_location` varchar(255) DEFAULT '',
  `browser` varchar(50) DEFAULT '',
  `os` varchar(50) DEFAULT '',
  `status` varchar(1) DEFAULT '0',
  `msg` varchar(255) DEFAULT '',
  `login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_logininfor`
--

LOCK TABLES `sys_logininfor` WRITE;
/*!40000 ALTER TABLE `sys_logininfor` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_logininfor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `menu_id` int NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) NOT NULL,
  `parent_id` int DEFAULT '0',
  `order_num` int DEFAULT NULL,
  `url` varchar(200) DEFAULT '',
  `menu_type` varchar(1) DEFAULT '' COMMENT 'menu type (M directory C menu F button)',
  `visible` varchar(1) DEFAULT '0' COMMENT '0 show 1 hide',
  `perms` varchar(100) DEFAULT '' COMMENT 'permission flag',
  `icon` varchar(100) DEFAULT '',
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT '',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2000 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'System management',0,1,'#','M','0','','fa fa-gear','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','System management directory'),(2,'System monitor',0,2,'#','M','0','','fa fa-video-camera','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','System monitor directory'),(3,'System tools',0,3,'#','M','0','','fa fa-bars','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','System tools directory'),(100,'UserManage',1,1,'/system/user','C','0','system:user:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','UserManage menu'),(101,'RoleManage',1,2,'/system/role','C','0','system:role:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','RoleManage menu'),(102,'MenuManage',1,3,'/system/menu','C','0','system:menu:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','MenuManage menu'),(103,'DepartmentManage',1,4,'/system/dept','C','0','system:dept:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','DepartmentManage menu'),(104,'PostionManage',1,5,'/system/post','C','0','system:post:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','PostionManage menu'),(105,'DicManage',1,6,'/system/dict','C','0','system:dict:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','DicManage menu'),(106,'ParamSetting',1,7,'/system/config','C','0','system:config:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','ParamSetting menu'),(107,'Notice',1,8,'/system/notice','C','0','system:notice:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','Notice menu'),(108,'OperateLog',2,1,'/monitor/operlog','C','0','monitor:operlog:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','OperateLog menu'),(109,'LoginLog',2,2,'/monitor/logininfor','C','0','monitor:logininfor:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','LoginLog'),(110,'OnlineUser',2,3,'/monitor/online','C','0','monitor:online:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','OnlineUser'),(111,'Schedule Task',2,4,'/monitor/job','C','0','monitor:job:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','Schedule Task'),(112,'DataMonitor',2,5,'/monitor/data','C','0','monitor:data:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','DataMonitor menu'),(113,'FormSetting',3,1,'/tool/build','C','0','tool:build:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','FormSetting menu'),(114,'CodeGenerate',3,2,'/tool/gen','C','0','tool:gen:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','CodeGenerate'),(115,'SystemInterface',3,3,'/tool/swagger','C','0','tool:swagger:view','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','SystemInterface menu'),(1000,'UserSearch',100,1,'#','F','0','system:user:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1001,'UserAdd',100,2,'#','F','0','system:user:add','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1002,'UserModify',100,3,'#','F','0','system:user:edit','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1003,'UserDelete',100,4,'#','F','0','system:user:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1004,'UserSave',100,5,'#','F','0','system:user:save','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1005,'PasswordReset',100,6,'#','F','0','system:user:resetPwd','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1006,'RoleSearch',101,1,'#','F','0','system:role:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1007,'RoleAdd',101,2,'#','F','0','system:role:add','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1008,'RoleModify',101,3,'#','F','0','system:role:edit','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1009,'RoleDelete',101,4,'#','F','0','system:role:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1010,'RoleSave',101,5,'#','F','0','system:role:save','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1011,'MenuSearch',102,1,'#','F','0','system:menu:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1012,'MenuAdd',102,2,'#','F','0','system:menu:add','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1013,'MenuModify',102,3,'#','F','0','system:menu:edit','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1014,'MenuDelete',102,4,'#','F','0','system:menu:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1015,'MenuSave',102,5,'#','F','0','system:menu:save','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1016,'DepartmentSearch',103,1,'#','F','0','system:dept:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1017,'DepartmentAdd',103,2,'#','F','0','system:dept:add','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1018,'DepartmentModify',103,3,'#','F','0','system:dept:edit','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1019,'DepartmentDelete',103,4,'#','F','0','system:dept:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1020,'DepartmentSave',103,5,'#','F','0','system:dept:save','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1021,'PositionSearch',104,1,'#','F','0','system:post:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1022,'PositionAdd',104,2,'#','F','0','system:post:add','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1023,'PositionModify',104,3,'#','F','0','system:post:edit','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1024,'PositionDelete',104,4,'#','F','0','system:post:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1025,'PositionSave',104,5,'#','F','0','system:post:save','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1026,'DicSearch',105,1,'#','F','0','system:dict:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1027,'DicAdd',105,2,'#','F','0','system:dict:add','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1028,'DicModify',105,3,'#','F','0','system:dict:edit','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1029,'DicDelete',105,4,'#','F','0','system:dict:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1030,'DicSave',105,5,'#','F','0','system:dict:save','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1031,'ParamSearch',106,1,'#','F','0','system:config:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1032,'ParamAdd',106,2,'#','F','0','system:config:add','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1033,'ParamModify',106,3,'#','F','0','system:config:edit','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1034,'ParamDelete',106,4,'#','F','0','system:config:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1035,'ParamSave',106,5,'#','F','0','system:config:save','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1036,'NoticeSearch',107,1,'#','F','0','system:notice:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1037,'NoticeAdd',107,2,'#','F','0','system:notice:add','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1038,'NoticeModify',107,3,'#','F','0','system:notice:edit','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1039,'NoticeDelete',107,4,'#','F','0','system:notice:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1040,'NoticeSave',107,5,'#','F','0','system:notice:save','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1041,'OperateSearch',108,1,'#','F','0','monitor:operlog:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1042,'OperateDelete',108,2,'#','F','0','monitor:operlog:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1043,'Details',108,3,'#','F','0','monitor:operlog:detail','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1044,'LoginSearch',109,1,'#','F','0','monitor:logininfor:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1045,'LoginDelete',109,2,'#','F','0','monitor:logininfor:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1046,'OnlineSearch',110,1,'#','F','0','monitor:online:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1047,'BatchForceStop',110,2,'#','F','0','monitor:online:batchForceLogout','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1048,'SingleTaskStop',110,3,'#','F','0','monitor:online:forceLogout','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1049,'TaskSearch',111,1,'#','F','0','monitor:job:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1050,'TaskAdd',111,2,'#','F','0','monitor:job:add','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1051,'TaskModify',111,3,'#','F','0','monitor:job:edit','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1052,'TaskDelete',111,4,'#','F','0','monitor:job:remove','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1053,'TaskSave',111,5,'#','F','0','monitor:job:save','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1054,'TaskModify',111,6,'#','F','0','monitor:job:changeStatus','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1055,'GenerateSearch',114,1,'#','F','0','tool:gen:list','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(1056,'GenerateCode',114,2,'#','F','0','tool:gen:code','#','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_notice`
--

DROP TABLE IF EXISTS `sys_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_notice` (
  `notice_id` int NOT NULL AUTO_INCREMENT,
  `notice_title` varchar(50) NOT NULL,
  `notice_type` varchar(2) NOT NULL COMMENT '1 notice 2 proclaim',
  `notice_content` varchar(500) NOT NULL,
  `status` varchar(1) DEFAULT '0' COMMENT '0 on 1 close',
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT '',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_notice`
--

LOCK TABLES `sys_notice` WRITE;
/*!40000 ALTER TABLE `sys_notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oper_log`
--

DROP TABLE IF EXISTS `sys_oper_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_oper_log` (
  `oper_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT '',
  `action` varchar(100) DEFAULT '',
  `method` varchar(100) DEFAULT '',
  `channel` varchar(20) DEFAULT '' COMMENT '（manage-backend user mobile-mobileuser other ）',
  `oper_name` varchar(50) DEFAULT '',
  `dept_name` varchar(50) DEFAULT '',
  `oper_url` varchar(255) DEFAULT '',
  `oper_ip` varchar(30) DEFAULT '',
  `oper_location` varchar(255) DEFAULT '',
  `oper_param` varchar(255) DEFAULT '',
  `status` varchar(1) DEFAULT '0' COMMENT '0 normla 1 stop',
  `error_msg` varchar(2000) DEFAULT '',
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oper_log`
--

LOCK TABLES `sys_oper_log` WRITE;
/*!40000 ALTER TABLE `sys_oper_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_oper_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_post`
--

DROP TABLE IF EXISTS `sys_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_post` (
  `post_id` int NOT NULL AUTO_INCREMENT,
  `post_code` varchar(64) NOT NULL,
  `post_name` varchar(50) NOT NULL,
  `post_sort` int NOT NULL,
  `status` varchar(1) NOT NULL COMMENT '0 normal 1 stop',
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT '',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_post`
--

LOCK TABLES `sys_post` WRITE;
/*!40000 ALTER TABLE `sys_post` DISABLE KEYS */;
INSERT INTO `sys_post` VALUES (1,'ceo','CEO',1,'0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(2,'se','Project manager',2,'0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(3,'hr','HR',3,'0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00',''),(4,'user','Employee',4,'0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','');
/*!40000 ALTER TABLE `sys_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) NOT NULL,
  `role_key` varchar(100) NOT NULL COMMENT 'role permission string',
  `role_sort` int NOT NULL,
  `status` varchar(1) NOT NULL COMMENT '0 normal 1 stop',
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT '',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'Administrator','admin',1,'0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','Administrator'),(2,'Normal role','common',2,'0','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','Normal role');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
  `role_id` int NOT NULL,
  `menu_id` int NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (1,1),(1,2),(1,3),(1,100),(1,101),(1,102),(1,103),(1,104),(1,105),(1,106),(1,107),(1,108),(1,109),(1,110),(1,111),(1,112),(1,113),(1,114),(1,115),(1,1000),(1,1001),(1,1002),(1,1003),(1,1004),(1,1005),(1,1006),(1,1007),(1,1008),(1,1009),(1,1010),(1,1011),(1,1012),(1,1013),(1,1014),(1,1015),(1,1016),(1,1017),(1,1018),(1,1019),(1,1020),(1,1021),(1,1022),(1,1023),(1,1024),(1,1025),(1,1026),(1,1027),(1,1028),(1,1029),(1,1030),(1,1031),(1,1032),(1,1033),(1,1034),(1,1035),(1,1036),(1,1037),(1,1038),(1,1039),(1,1040),(1,1041),(1,1042),(1,1043),(1,1044),(1,1045),(1,1046),(1,1047),(1,1048),(1,1049),(1,1050),(1,1051),(1,1052),(1,1053),(1,1054),(1,1055),(1,1056);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `dept_id` int DEFAULT NULL,
  `login_name` varchar(30) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `user_type` varchar(2) DEFAULT '00' COMMENT '00 system user',
  `email` varchar(50) DEFAULT '',
  `phonenumber` varchar(11) DEFAULT '',
  `sex` varchar(1) DEFAULT '0' COMMENT '（0 male 1female 2unknown）',
  `avatar` varchar(100) DEFAULT '' COMMENT 'path of headphoto',
  `password` varchar(50) DEFAULT '',
  `salt` varchar(20) DEFAULT '',
  `status` varchar(1) DEFAULT '0' COMMENT 'account status（0 normal 1stop）',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '0 exist 2 delete',
  `login_ip` varchar(20) DEFAULT '',
  `login_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT '',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,106,'admin','GS','00','ry@163.com','15888888888','1','','29c67a30398638269fe600f73a054934','111111','0','0','127.0.0.1','2023-08-30 11:33:00','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','Administrator'),(2,108,'ry','GS','00','ry@qq.com','15666666666','1','','8e6d98b90472783cc73c17047ddccf36','222222','0','0','127.0.0.1','2023-08-30 11:33:00','admin','2023-08-30 11:33:00','ry','2023-08-30 11:33:00','Administrator');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_online`
--

DROP TABLE IF EXISTS `sys_user_online`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_online` (
  `sessionId` varchar(50) NOT NULL DEFAULT '',
  `login_name` varchar(50) DEFAULT '',
  `dept_name` varchar(50) DEFAULT '',
  `ipaddr` varchar(50) DEFAULT '',
  `login_location` varchar(255) DEFAULT '',
  `browser` varchar(50) DEFAULT '',
  `os` varchar(50) DEFAULT '',
  `status` varchar(10) DEFAULT '' COMMENT 'on_line off_line',
  `start_timestsamp` datetime DEFAULT NULL,
  `last_access_time` datetime DEFAULT NULL,
  `expire_time` int DEFAULT '0',
  PRIMARY KEY (`sessionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_online`
--

LOCK TABLES `sys_user_online` WRITE;
/*!40000 ALTER TABLE `sys_user_online` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_online` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_post`
--

DROP TABLE IF EXISTS `sys_user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_post` (
  `user_id` varchar(64) NOT NULL,
  `post_id` varchar(64) NOT NULL,
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_post`
--

LOCK TABLES `sys_user_post` WRITE;
/*!40000 ALTER TABLE `sys_user_post` DISABLE KEYS */;
INSERT INTO `sys_user_post` VALUES ('1','1'),('2','2');
/*!40000 ALTER TABLE `sys_user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-02  1:10:50


-- ----------------------------
-- Table structure for score_class
-- ----------------------------
DROP TABLE IF EXISTS `score_class`;
CREATE TABLE `score_class`  (
        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
        `create_user_name` varchar(10)  NULL DEFAULT NULL ,
        `create_time` datetime(0) NULL DEFAULT NULL ,
        `update_user_name` varchar(10)  NULL DEFAULT NULL ,
        `update_time` datetime(0) NULL DEFAULT NULL ,
        `class_no` varchar(20)  NULL DEFAULT NULL ,
        `class_name` varchar(10)  NULL DEFAULT NULL,
        `class_teacher` varchar(10)  NULL DEFAULT NULL ,
        `class_status` int(1) NULL DEFAULT NULL COMMENT 'class status（1：available；2：non-available）',
        `class_desc` varchar(100)  NULL DEFAULT NULL ,
        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB ;

-- ----------------------------
-- Records of score_class
-- ----------------------------
INSERT INTO `score_class` VALUES (1, 'Teacher Liu', '2023-05-14 20:14:52', 'Teacher Liu', '2023-05-14 20:14:59', '8537240', 'Grade one', 'Jerry', 1, 'Excellent class');
INSERT INTO `score_class` VALUES (2, 'Teacher Liu', '2023-05-14 20:15:14', 'Teacher Liu', '2023-05-14 20:15:16', '0741478', 'Grade two', 'Tom', 1, 'Good class');
INSERT INTO `score_class` VALUES (3, 'Teacher Liu', '2023-05-14 20:15:35', 'Teacher Liu', '2023-05-14 20:15:37', '4855566', 'Grade three', 'Felix', 1, 'Nice class');
INSERT INTO `score_class` VALUES (4, 'Teacher Liu', '2023-05-14 20:15:48', 'Teacher Liu', '2023-05-14 20:16:08', '6187162', 'Grade four', 'Cathy', 1, 'Elegant class');
INSERT INTO `score_class` VALUES (5, 'Teacher Liu', '2023-05-14 20:16:04', 'Teacher Liu', '2023-05-14 20:16:06', '0402136', 'Grade five', 'John', 1, 'Rock star');

-- ----------------------------
-- Table structure for score_details
-- ----------------------------
DROP TABLE IF EXISTS `score_details`;
CREATE TABLE `score_details`  (
          `id` bigint(20) NOT NULL AUTO_INCREMENT ,
          `create_user_name` varchar(10)  NULL DEFAULT NULL ,
          `create_time` datetime(0) NULL DEFAULT NULL ,
          `update_user_name` varchar(10)  NULL DEFAULT NULL ,
          `update_time` datetime(0) NULL DEFAULT NULL ,
          `stu_id` bigint(20) NULL DEFAULT NULL ,
          `subject_id` bigint(20) NULL DEFAULT NULL ,
          `score_value` int(11) NULL DEFAULT NULL ,
          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB ;

-- ----------------------------
-- Records of score_details
-- ----------------------------
INSERT INTO `score_details` VALUES (1, 'Teacher Liu', '2023-05-14 22:18:12', 'Teacher Liu', '2023-05-14 22:18:16', 1, 4, 99);
INSERT INTO `score_details` VALUES (2, 'Teacher Liu', '2023-05-14 22:22:07', 'Teacher Liu', '2023-05-14 22:23:00', 2, 1, 69);
INSERT INTO `score_details` VALUES (3, 'Teacher Liu', '2023-05-14 22:22:51', 'Teacher Liu', '2023-05-14 22:23:02', 1, 1, 85);
INSERT INTO `score_details` VALUES (4, 'Teacher Liu', '2023-05-14 22:22:58', 'Teacher Liu', '2023-05-14 22:23:03', 2, 7, 89);

-- ----------------------------
-- Table structure for score_student
-- ----------------------------
DROP TABLE IF EXISTS `score_student`;
CREATE TABLE `score_student`  (
          `id` bigint(20) NOT NULL AUTO_INCREMENT ,
          `create_user_name` varchar(10) NULL DEFAULT NULL ,
          `create_time` datetime(0) NULL DEFAULT NULL ,
          `update_user_name` varchar(10)  NULL DEFAULT NULL ,
          `update_time` datetime(0) NULL DEFAULT NULL,
          `stu_no` varchar(20)  NULL DEFAULT NULL ,
          `stu_name` varchar(10)  NULL DEFAULT NULL ,
          `stu_phone` varchar(11)  NULL DEFAULT NULL ,
          `stu_class` varchar(10)  NULL DEFAULT NULL ,
          `stu_status` int(1) NULL DEFAULT NULL COMMENT 'student status（1：available；2：non-available）',
          `stu_desc` varchar(100) NULL DEFAULT NULL ,
          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB ;

-- ----------------------------
-- Records of score_student
-- ----------------------------
INSERT INTO `score_student` VALUES (1, 'Teacher Liu', '2023-05-14 20:48:07', NULL, NULL, 'stu_083163148', 'Feng Li', '18011111111', 'Grade three', 1, 'Good student');
INSERT INTO `score_student` VALUES (2, 'Teacher Liu', '2023-05-14 20:48:25', NULL, NULL, 'stu_331821521', 'Xun zhu', '18012520000', 'Grade five', 1, 'Excellent officer');
INSERT INTO `score_student` VALUES (3, 'Teacher Liu', '2023-05-14 20:48:51', 'Teacher Liu', '2023-05-14 20:49:00', 'stu_133745336', 'Yan Yan', '18023222222', 'Grade four', 2, 'Fired');

-- ----------------------------
-- Table structure for score_subject
-- ----------------------------
DROP TABLE IF EXISTS `score_subject`;
CREATE TABLE `score_subject`  (
                  `id` bigint(20) NOT NULL AUTO_INCREMENT ,
                  `create_user_name` varchar(10)  NULL DEFAULT NULL ,
                  `create_time` datetime(0) NULL DEFAULT NULL ,
                  `update_user_name` varchar(10)  NULL DEFAULT NULL ,
                  `update_time` datetime(0) NULL DEFAULT NULL ,
                  `subject_no` varchar(30)  NULL DEFAULT NULL ,
                  `subject_name` varchar(20)  NULL DEFAULT NULL ,
                  `subject_status` int(1) NULL DEFAULT NULL COMMENT 'subject status（1：available；2：non-available）',
                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB ;

-- ----------------------------
-- Records of score_subject
-- ----------------------------
INSERT INTO `score_subject` VALUES (1, 'Teacher Liu', '2023-05-14 19:46:54', NULL, NULL, '878830', 'Literature', 1);
INSERT INTO `score_subject` VALUES (2, 'Teacher Liu', '2023-05-14 19:46:59', NULL, NULL, '477638', 'Math', 1);
INSERT INTO `score_subject` VALUES (3, 'Teacher Liu', '2023-05-14 19:49:46', NULL, NULL, '442258', 'English', 1);
INSERT INTO `score_subject` VALUES (4, 'Teacher Liu', '2023-05-14 19:49:50', 'Teacher Liu', '2023-05-14 19:59:29', '671320', 'Chemical', 1);
INSERT INTO `score_subject` VALUES (5, 'Teacher Liu', '2023-05-14 19:49:54', NULL, NULL, '055783', 'Physics', 1);
INSERT INTO `score_subject` VALUES (6, 'Teacher Liu', '2023-05-14 19:52:01', 'Teacher Liu', '2023-05-14 19:59:28', '112400', 'Geography', 1);
INSERT INTO `score_subject` VALUES (7, 'Teacher Liu', '2023-05-14 19:52:09', 'Teacher Liu', '2023-05-14 19:59:26', '332436', 'Biological', 1);
INSERT INTO `score_subject` VALUES (8, 'Teacher Liu', '2023-05-14 19:52:14', 'Teacher Liu', '2023-05-14 19:59:24', '067133', 'Physical Education', 1);
INSERT INTO `score_subject` VALUES (9, 'Teacher Liu', '2023-05-14 19:52:19', 'Teacher Liu', '2023-05-14 19:59:23', '485055', 'Music', 1);
INSERT INTO `score_subject` VALUES (10, 'Teacher Liu', '2023-05-14 19:52:22', 'Teacher Liu', '2023-05-14 19:59:21', '055444', 'History', 1);
INSERT INTO `score_subject` VALUES (11, 'Teacher Liu', '2023-05-14 19:52:28', 'Teacher Liu', '2023-05-14 19:59:19', '281511', 'Nature', 2);

-- ----------------------------
-- Table structure for score_teacher
-- ----------------------------
DROP TABLE IF EXISTS `score_teacher`;
CREATE TABLE `score_teacher`  (
                      `id` bigint(20) NOT NULL AUTO_INCREMENT ,
                      `create_user_name` varchar(10)  NULL DEFAULT NULL ,
                      `create_time` datetime(0) NULL DEFAULT NULL ,
                      `update_user_name` varchar(10)  NULL DEFAULT NULL ,
                      `update_time` datetime(0) NULL DEFAULT NULL ,
                      `tea_no` varchar(20)  NULL DEFAULT NULL ,
                      `tea_name` varchar(10)  NULL DEFAULT NULL ,
                      `tea_phone` varchar(11)  NULL DEFAULT NULL,
                      `tea_status` int(1) NULL DEFAULT NULL  COMMENT 'teacher status（1：available；2：non-available）',
                      `tea_desc` varchar(100)  NULL DEFAULT NULL ,
                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB ;

-- ----------------------------
-- Records of score_teacher
-- ----------------------------
INSERT INTO `score_teacher` VALUES (1, 'Teacher Liu', '2023-05-14 17:59:34', 'Teacher Liu', '2023-05-14 19:56:37', 'tea_428064277', 'San Zhang', '18052625352', 1, 'Good teacher');
INSERT INTO `score_teacher` VALUES (3, 'Teacher Liu', '2023-05-14 19:56:54', 'Teacher Liu', '2023-05-14 19:58:33', 'tea_273520512', 'Si Li', '18052000000', 1, 'Excellent teacher');
INSERT INTO `score_teacher` VALUES (4, 'Teacher Liu', '2023-05-14 19:57:05', 'Teacher Liu', '2023-05-14 19:58:35', 'tea_244684283', 'Wu Wang', '18011120000', 1, 'Perfect teacher');
INSERT INTO `score_teacher` VALUES (5, 'Teacher Liu', '2023-05-14 19:57:24', 'Teacher Liu', '2023-05-14 19:58:37', 'tea_715171650', 'Liu Zhao', '18012302012', 1, 'Nice teacher');
