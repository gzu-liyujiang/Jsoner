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
 * 使用`FastJSON`须添加依赖：runtimeOnly 'com.alibaba:fastjson:1.2.70'。
 * 使用`GSON`须添加依赖：runtimeOnly 'com.google.code.gson:gson:2.8.6'。
 *
 * @author 贵州山魈羡民 (1032694760@qq.com)
 * @since 2020/6/22
 */
public class JsonStrategy implements IJson {
    private static final String MESSAGE = "Please add dependency `runtimeOnly 'com.alibaba:fastjson:xxx'`" +
            " or `runtimeOnly 'com.google.code.gson:gson:xxx'` in your app/build.gradle";
    private static final JsonStrategy INSTANCE = new JsonStrategy();
    private IJson strategy;

    private JsonStrategy() {
        super();
        try {
            Class.forName(com.alibaba.fastjson.JSON.class.getName());
            strategy = new FastJsonImpl();
        } catch (ClassNotFoundException | NoClassDefFoundError e) {
            try {
                Class.forName(com.google.gson.Gson.class.getName());
                strategy = new GsonImpl();
            } catch (ClassNotFoundException | NoClassDefFoundError ignore) {
            }
        }
    }

    public static IJson getDefault() {
        if (INSTANCE.strategy == null) {
            throw new RuntimeException(MESSAGE);
        }
        return INSTANCE.strategy;
    }

    public static void setStrategy(IJson strategy) {
        INSTANCE.strategy = strategy;
    }

    @Override
    public <T> T parseObject(String text, Class<T> clazz) throws RuntimeException {
        return getDefault().parseObject(text, clazz);
    }

    @Override
    public <T> List<T> parseArray(String text, Class<T> clazz) throws RuntimeException {
        return getDefault().parseArray(text, clazz);
    }

    @Override
    public String toJsonString(Object instance) throws RuntimeException {
        return getDefault().toJsonString(instance);
    }

}
