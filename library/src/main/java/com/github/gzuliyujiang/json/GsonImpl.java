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

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 贵州山魈羡民 (1032694760@qq.com)
 * @since 2020/5/14
 */
final class GsonImpl implements IJson {

    @Override
    public <T> T parseObject(String text, Class<T> clazz) throws RuntimeException {
        try {
            return new Gson().fromJson(text, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> parseArray(String text, Class<T> clazz) throws RuntimeException {
        List<T> data = new ArrayList<>();
        try {
            // com.google.gson.internal.LinkedTreeMap cannot be cast to XXX
            JSONArray jsonArray = new JSONArray(text);
            for (int i = 0, n = jsonArray.length(); i < n; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                T item = new Gson().fromJson(jsonObject.toString(), clazz);
                data.add(item);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public String toJsonString(Object instance) throws RuntimeException {
        try {
            return new Gson().toJson(instance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
