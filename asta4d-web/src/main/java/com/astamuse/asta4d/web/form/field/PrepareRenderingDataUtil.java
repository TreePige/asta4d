/*
 * Copyright 2014 astamuse company,Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.astamuse.asta4d.web.form.field;

import com.astamuse.asta4d.Context;

public class PrepareRenderingDataUtil {

    private static final String dataStoreKey(String selector) {
        return selector + "#" + PrepareRenderingDataUtil.class.getName();
    }

    public static final void storeDataToContextBySelector(String editTargetSelector, String displayTargetSelector, Object data) {
        Context context = Context.getCurrentThreadContext();

        String storeKey = dataStoreKey(editTargetSelector);
        context.setData(storeKey, data);

        storeKey = dataStoreKey(displayTargetSelector);
        context.setData(storeKey, data);
    }

    public static <T> T retrieveStoredDataFromContextBySelector(String selector) {
        String storeKey = dataStoreKey(selector);
        Context context = Context.getCurrentThreadContext();
        return context.getData(storeKey);
    }
}
