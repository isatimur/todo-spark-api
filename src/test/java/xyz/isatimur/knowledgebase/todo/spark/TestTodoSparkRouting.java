/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Timur Isachenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
 * USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package xyz.isatimur.knowledgebase.todo.spark;

import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

/**
 * @author ${USER} {@literal <tisachenko@at-consulting.ru>} on ${DATE}.
 *         Test checking that system is available and return status code 200 and content is equal.
 */
public class TestTodoSparkRouting {
    private static final int OK_STATUS = 200;
    private static final int CREATED_STATUS = 201;

    /**
     * initialization before start of test.
     */
    @Before
    public void start() {
        TodoSparkRouting sparkRouting = new TodoSparkRouting();
    }

    /**
     * Todo resource should return 200 on GET request.
     */
    @Test
    public void todoResourceReturns200WithExpectedResult() {
        given()
                .when()
                .get("http://localhost:4567/todo")
                .then()
                .assertThat()
                .statusCode(OK_STATUS)
                .and()
                .body("body", contains("GET /todo"));
    }

    /**
     * Todo resource should return 200 on POST request.
     */
    @Test
    public void todoResourcePost201WithExpectedResult() {
        given()
                .when()
                .post("http://localhost:4567/todo")
                .then()
                .assertThat()
                .statusCode(CREATED_STATUS)
                .and()
                .body("body", contains("POST /todo"));
    }
}