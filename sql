/*
 Navicat Premium Data Transfer

 Source Server         : ldh
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : ldhmusic

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 27/06/2021 20:17:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `roleId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_user', 'user');
INSERT INTO `role` VALUES ('2', 'ROLE_vip_user', 'vip_user');

-- ----------------------------
-- Table structure for singer
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer`  (
  `singerId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `singerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `singImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `singerText` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`singerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of singer
-- ----------------------------
INSERT INTO `singer` VALUES ('1', '陈奕迅', 'cyx.png', '华语流行歌手');
INSERT INTO `singer` VALUES ('2', '宋冬野', 'sdy.jpg', '华语民谣歌手');

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song`  (
  `songId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `songName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `singerId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specialName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `songUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `songImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`songId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of song
-- ----------------------------
INSERT INTO `song` VALUES ('1', '爱情转移', '1', '爱情转移', '爱情转移.mp3', NULL);
INSERT INTO `song` VALUES ('10', '鸽子', '2', '安河桥北', NULL, NULL);
INSERT INTO `song` VALUES ('11', '安河桥', '2', '安河桥北', NULL, NULL);
INSERT INTO `song` VALUES ('12', '郭源潮', '2', '郭源潮', '郭源潮.mp3', NULL);
INSERT INTO `song` VALUES ('2', '十年', '1', '你的陈奕迅', NULL, NULL);
INSERT INTO `song` VALUES ('3', '阴天快乐', '1', 'rice & shine', NULL, NULL);
INSERT INTO `song` VALUES ('4', '你给我听好', '1', 'rice & shine', NULL, NULL);
INSERT INTO `song` VALUES ('5', '娱乐天空', '1', 'rice & shine', NULL, NULL);
INSERT INTO `song` VALUES ('6', 'K歌之王（粤语）', '1', '你的陈奕迅', NULL, NULL);
INSERT INTO `song` VALUES ('7', '单车', '1', '粤语', NULL, NULL);
INSERT INTO `song` VALUES ('8', '谢谢侬', '1', '你的陈奕迅', NULL, NULL);
INSERT INTO `song` VALUES ('9', '关忆北', '2', '安河桥北', '关忆北.mp3', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(11) NOT NULL,
  `userName` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `userPassword` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `userImg` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (599, 'ldh', '$2a$10$yoSLYwEYrPbB6oytTRRMwO/M1/48XfTfBMhjVzqAPrEQG8AsurLOC', 'cb');

-- ----------------------------
-- Table structure for user_like_songs
-- ----------------------------
DROP TABLE IF EXISTS `user_like_songs`;
CREATE TABLE `user_like_songs`  (
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `songId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_like_songs
-- ----------------------------
INSERT INTO `user_like_songs` VALUES (NULL, '6');
INSERT INTO `user_like_songs` VALUES (NULL, '12');
INSERT INTO `user_like_songs` VALUES (NULL, '12');
INSERT INTO `user_like_songs` VALUES ('599', '11');
INSERT INTO `user_like_songs` VALUES ('599', '12');
INSERT INTO `user_like_songs` VALUES ('599', '1');
INSERT INTO `user_like_songs` VALUES ('599', '2');
INSERT INTO `user_like_songs` VALUES ('599', '4');
INSERT INTO `user_like_songs` VALUES ('599', '3');
INSERT INTO `user_like_songs` VALUES ('599', '9');

-- ----------------------------
-- Table structure for user_list
-- ----------------------------
DROP TABLE IF EXISTS `user_list`;
CREATE TABLE `user_list`  (
  `userListId` int(11) NOT NULL,
  `userListName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userId` int(11) NULL DEFAULT NULL,
  `userListText` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userListImgUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userListId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_list
-- ----------------------------
INSERT INTO `user_list` VALUES (0, '新建歌单', NULL, '+ 点击修改歌单简介', 'music.jpg');
INSERT INTO `user_list` VALUES (5990, '陈奕迅的歌', 599, '这是我非常喜欢的华语歌手陈奕迅', 'cyx.png');
INSERT INTO `user_list` VALUES (5991, '宋冬野', 599, '我喜欢的宋冬野民谣21312313132\n\n\n\n', 'sdy.jpg');
INSERT INTO `user_list` VALUES (5993, '新建歌单', 599, '+ 点击修改歌单简介', 'music.jpg');

-- ----------------------------
-- Table structure for user_list_songs
-- ----------------------------
DROP TABLE IF EXISTS `user_list_songs`;
CREATE TABLE `user_list_songs`  (
  `userListId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `songId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_list_songs
-- ----------------------------
INSERT INTO `user_list_songs` VALUES ('5991', '10');
INSERT INTO `user_list_songs` VALUES ('5991', '9');
INSERT INTO `user_list_songs` VALUES ('5993', '9');
INSERT INTO `user_list_songs` VALUES ('5993', '12');
INSERT INTO `user_list_songs` VALUES ('5992', '12');
INSERT INTO `user_list_songs` VALUES ('5990', '12');
INSERT INTO `user_list_songs` VALUES ('5990', '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('599', '1');
INSERT INTO `user_role` VALUES ('598', '2');

SET FOREIGN_KEY_CHECKS = 1;
