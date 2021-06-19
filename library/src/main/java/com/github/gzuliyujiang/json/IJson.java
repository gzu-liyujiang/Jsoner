/*
 * Copyright (c) 2016-present 贵州纳雍穿青人李裕江<1032694760@qq.com>
 *
 * The software is licensed under the Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *     http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR
 * PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package com.github.gzuliyujiang.json;

import java.util.List;

/**
 * 面向接口编程，使用接口对各模块进行解耦，增强对第三方库的管控，不强依赖某些三方库，使得三方库可自由搭配组装。
 * <p>
 * 集成第三方JSON框架（如：FastJSON、gson、orgJSON、moshi、Jackson、simpleJSON），
 * <p>
 * https://github.com/alibaba/fastjson
 * https://github.com/google/gson
 * https://github.com/square/moshi
 *
 * @author 贵州山魈羡民 (1032694760@qq.com)
 * @since 2016/12/31
 * @since 2020/5/14
 */
public interface IJson {

    <T> T parseObject(String text, Class<T> clazz) throws RuntimeException;

    <T> List<T> parseArray(String text, Class<T> clazz) throws RuntimeException;

    String toJsonString(Object instance) throws RuntimeException;

}
