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

import spark.Spark;

/**
 * @author ${USER} {@literal <tisachenko@at-consulting.ru>} on ${DATE}.
 *         TodoSparkRouting is a basic routing configuration
 *         to prove simplest usage of this lightweight web framework Spark.
 */
public class TodoSparkRouting {
    TodoSparkRouting() {
        initRouters();
    }

    /**
     * Here we start our small application.
     * Commented bag.
     *
     * @param args default method signature.
     */
    public static void main(String[] args) {
        new TodoSparkRouting();
    }

    /**
     * This is a main method of setting routers for our application.
     * Of course in lambda expression you can see the handling lambda expression.
     */
    public static void initRouters() {
        Spark.get(
                new RouterClass("/", (req, res) -> "GET /todo", "application/json")
        );
        Spark.get(
                new RouterClass("/todo", (req, res) -> "GET /todo", "application/json")
        );

        Spark.get(
                new RouterClass("/todo/:todoId", (req, res) -> "GET /todo/" + req.params(":todoId"))
        );

        Spark.post(
                new RouterClass("/todo", (req, res) -> "POST /todo")
        );

        Spark.put(
                new RouterClass("/todo/:todoId", (req, res) -> "PUT /todo/" + req.params(":todoId"))
        );

        Spark.delete(
                new RouterClass("/todo/:todoId", (req, res) -> "DELETE /todo/:todoId" + req.params(":todoId"))
        );

    }
}

