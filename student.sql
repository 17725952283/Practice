/*
 Navicat MySQL Data Transfer

 Source Server         : YIZHIMAi
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : sys

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 20/12/2022 11:12:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `className` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JavaScore` float(10, 2) NULL DEFAULT 0.00,
  `MathScore` float(10, 2) NULL DEFAULT 0.00,
  `EnglishScore` float(10, 2) NULL DEFAULT 0.00,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'SugawaraEita', '1', 89.00, 100.00, 100.00, '123456');
INSERT INTO `student` VALUES (2, 'TaoWaiYee', '1', 60.70, 55.30, 100.00, 'EQVVAtWS7E');
INSERT INTO `student` VALUES (3, 'KuWaiMan', '1', 55.30, 55.30, 44.00, 'dnpY2oMWG3');
INSERT INTO `student` VALUES (4, 'OnoSara', '1', 60.70, 55.30, 60.70, '9fGxBY3Rs5');
INSERT INTO `student` VALUES (5, 'ChinYunFat', '1', 60.70, 55.30, 60.70, 'PFGyTWfIMC');
INSERT INTO `student` VALUES (6, 'YungChungYin', '1', 60.70, 55.30, 60.70, 'PFGyTWfIMC');
INSERT INTO `student` VALUES (7, 'DavidKing', '1', 90.60, 90.60, 60.70, '3owDX8A2VM');
INSERT INTO `student` VALUES (8, 'ChanFat', '1', 80.10, 71.00, 60.70, '1LZbzop5Gv');
INSERT INTO `student` VALUES (9, 'YamadaRiku', '1', 60.70, 60.70, 60.70, 'EQVVAtWS7E');
INSERT INTO `student` VALUES (10, 'IchikawaMiu', '1', 80.10, 60.70, 60.70, '7xxJ4z3W4N');
INSERT INTO `student` VALUES (11, 'YamashitaTakuya', '2', 80.10, 60.70, 80.10, 'lhW3dGuEQp');
INSERT INTO `student` VALUES (12, 'KanekoNanami', '2', 80.10, 60.70, 80.10, 'dnpY2oMWG3');
INSERT INTO `student` VALUES (14, 'Katherine Diaz', '2', 80.10, 9.46, 60.70, 'racEnlpT2y');
INSERT INTO `student` VALUES (15, 'UchidaAkina', '2', 86.00, 55.30, 60.70, 'hZYVU6vk54');
INSERT INTO `student` VALUES (16, 'ManSaiWing', '2', 80.10, 60.70, 60.70, 'Z06OJ36EaT');
INSERT INTO `student` VALUES (17, 'SakamotoAiri', '2', 80.10, 60.70, 60.70, '51h85iafVM');
INSERT INTO `student` VALUES (18, 'NormanSanchez', '2', 60.70, 55.30, 60.70, 'eKgqmhX9U5');
INSERT INTO `student` VALUES (19, 'MoritaMai', '2', 80.10, 55.30, 53.60, 'gCimrz1QaN');
INSERT INTO `student` VALUES (20, 'KatoMio', '2', 60.70, 55.30, 53.60, 'YBOxodZCPk');
INSERT INTO `student` VALUES (21, 'EvelynChen', '3', 45.00, 80.10, 53.60, 'KFqVHSvBG2');
INSERT INTO `student` VALUES (22, 'SakamotoAoi', '3', 80.10, 55.30, 95.00, 'YODhFajNrN');
INSERT INTO `student` VALUES (23, 'LinXiaoming', '3', 80.10, 80.10, 94.00, '9qvYqJ9jmB');
INSERT INTO `student` VALUES (24, 'FujiwaraKaito', '3', 80.10, 80.10, 93.00, 'u3uCsTGDJs');
INSERT INTO `student` VALUES (25, 'SuzukiKenta', '3', 80.10, 34.36, 92.00, 'Wnfk2dvcDg');
INSERT INTO `student` VALUES (26, 'GuYuning', '3', 80.10, 734.05, 91.00, 'ODVL6QJh53');
INSERT INTO `student` VALUES (27, 'DaiJialun', '3', 80.10, 74.30, 90.00, '3uNvhdPYBn');
INSERT INTO `student` VALUES (28, 'YungLikSun', '3', 80.10, 74.30, 55.00, 'uvkF9R4rN7');
INSERT INTO `student` VALUES (29, 'DeniseOlson', '3', 34.36, 34.36, 54.00, 'kjEml9bbWq');
INSERT INTO `student` VALUES (30, 'DeniseJohnson', '3', 74.30, 74.30, 33.00, 'mHqKvWe6Mg');
INSERT INTO `student` VALUES (31, 'KimberlyWhite', '4', 29.02, 34.36, 34.00, 'Jm6Ou75w7d');
INSERT INTO `student` VALUES (32, 'HasegawaHikaru', '4', 29.02, 29.02, 63.00, 'GtfMSczjvK');
INSERT INTO `student` VALUES (33, 'KondoKaito', '4', 68.00, 34.36, 80.10, 'NMuqN0C7Ws');
INSERT INTO `student` VALUES (34, 'DawnStone', '4', 61.00, 74.30, 80.10, 'UecJqIoLMO');
INSERT INTO `student` VALUES (35, 'BillyWood', '4', 80.00, 74.30, 80.10, 'H9hLmj5CuL');
INSERT INTO `student` VALUES (36, 'DuRui', '4', 55.00, 96.81, 80.10, 'OIU3K78CnZ');
INSERT INTO `student` VALUES (37, 'TakadaItsuki', '4', 13.00, 34.00, 80.10, 'GS5n8fHUdM');
INSERT INTO `student` VALUES (38, 'YuenSaiWing', '4', 80.00, 50.00, 80.10, 'AbAq6skhSV');
INSERT INTO `student` VALUES (39, 'HsuanKaLing', '4', 63.00, 90.00, 80.10, 'W0gdP8edNQ');
INSERT INTO `student` VALUES (40, 'AbeAkina', '4', 64.00, 88.00, 80.10, 'RePncDah8w');
INSERT INTO `student` VALUES (41, 'AbeAyato', '5', 65.00, 67.00, 47.34, 'L2AH9dRB7Z');
INSERT INTO `student` VALUES (42, 'Yokoyama Sara', '5', 68.00, 88.00, 80.10, '5uE1XUjIos');
INSERT INTO `student` VALUES (43, 'HungKarYan', '5', 33.00, 67.00, 83.00, 'bDIZNLHONf');
INSERT INTO `student` VALUES (44, 'Lam WingSuen', '5', 30.95, 66.00, 84.00, 'FQOab5jJyh');
INSERT INTO `student` VALUES (45, 'FanXiuying', '5', 35.00, 77.00, 80.10, 'IWOItXDfKa');
INSERT INTO `student` VALUES (46, 'DennisWalker', '5', 30.95, 71.00, 34.00, 'zS7z4iYIiq');
INSERT INTO `student` VALUES (47, 'ChuKaMing', '5', 86.00, 81.00, 66.00, 'YKQBBZLZ5c');
INSERT INTO `student` VALUES (48, 'RitaKelley', '5', 30.95, 81.00, 80.00, 'E477gBoLyq');
INSERT INTO `student` VALUES (49, 'ShiLan', '5', 90.00, 68.00, 70.00, '88Pnmd81Fs');
INSERT INTO `student` VALUES (50, 'FuWingFat', '5', 30.95, 48.00, 80.10, 'v6f44JuLBx');

SET FOREIGN_KEY_CHECKS = 1;
