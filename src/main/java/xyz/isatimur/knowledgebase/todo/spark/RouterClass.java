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

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * @author ${USER} {@literal <tisachenko@at-consulting.ru>} on ${DATE}.
 *         This class goal is to create opportunity for using Java 8
 *         Lambda expressions by integrating functional interface <code>Routing</code>.
 */
public class RouterClass extends Route {

    private Routing routing;

    protected RouterClass(String path, Routing routing) {
        super(path);
        this.routing = routing;
    }

    protected RouterClass(String path, Routing routing, String acceptType) {
        super(path, acceptType);
        this.routing = routing;
    }

    @Override
    public Object handle(final Request request, final Response response) {
        return routing.handleRoute(request, response);
    }

    /**
     * This is a delegating function to be able halt a request in time of custom error.
     *
     * @param halt can be and a number of error
     */
    public static void halting(int halt) {
        halt(halt);
    }

}