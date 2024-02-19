/*
 * Copyright 2018. nekocode (nekocode.cn@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.nekocode.caka.backend

import cn.nekocode.caka.backend.api.RepoApi
import cn.nekocode.caka.backend.di.module.ApiModule
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Ignore
import org.junit.Test
import javax.inject.Inject

/**
 * @author nekocode (nekocode.cn@gmail.com)
 */
class ApiTest {
    init {
        val httpClientBuilder = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor { message ->
                println(message)
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            })

        DaggerTestComponent.builder()
            .apiModule(ApiModule(httpClientBuilder, GsonBuilder()))
            .build()
            .inject(this)
    }

    @Inject
    lateinit var repoApi: RepoApi

    @Test
    @Ignore("Comment this line to test this method")
    fun listRepos() {
        repoApi.listRepos("nekocode")
            .test()
            .await()
            .assertNoErrors()
            .assertValue { repos ->
                repos.size > 0
            }
    }
}
