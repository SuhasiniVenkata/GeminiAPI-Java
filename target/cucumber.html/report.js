$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/com/features/geminiassignment.feature");
formatter.feature({
  "name": "Automation tests for placing new orders and cancel the orders",
  "description": "  Description: The purpose of these tests are to cover customer place new order and cancel the orders",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Run_Orders_POST"
    }
  ]
});
formatter.scenarioOutline({
  "name": "test Create Orders POST request",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Run_Orders_POST_1"
    }
  ]
});
formatter.step({
  "name": "I call \u0027gemini new order create and cancel\u0027 webservice",
  "keyword": "Given ",
  "rows": [
    {
      "cells": [
        "request",
        "/v1/order/new"
      ]
    },
    {
      "cells": [
        "request",
        "/v1/order/new"
      ]
    },
    {
      "cells": [
        "nonce",
        "\u003cnonce\u003e"
      ]
    },
    {
      "cells": [
        "symbol",
        "\u003csymbol\u003e"
      ]
    },
    {
      "cells": [
        "amount",
        "\u003camount\u003e"
      ]
    },
    {
      "cells": [
        "price",
        "200"
      ]
    },
    {
      "cells": [
        "client_order_id",
        "\u003cclient_order_id\u003e"
      ]
    },
    {
      "cells": [
        "side",
        "\u003cside\u003e"
      ]
    },
    {
      "cells": [
        "type",
        "\u003ctype\u003e"
      ]
    },
    {
      "cells": [
        "gemini_api_secret",
        "4YgPvW19cb9Ej3GbjnPtNFSxZf6M"
      ]
    }
  ]
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "nonce",
        "symbol",
        "amount",
        "side",
        "client_order_id",
        "type"
      ]
    },
    {
      "cells": [
        "12345",
        "btcusd",
        "5",
        "buy",
        "1234",
        "exchange limit"
      ]
    },
    {
      "cells": [
        "12346",
        "Ether",
        "5",
        "",
        "2134",
        "exchange limit"
      ]
    },
    {
      "cells": [
        "12347",
        "Ether,btcusd",
        "5",
        "sell",
        "2134",
        "exchange limit"
      ]
    },
    {
      "cells": [
        "12348",
        "Ether,btcusd",
        "5",
        "",
        "2134",
        "exchange limit"
      ]
    }
  ]
});
formatter.scenario({
  "name": "test Create Orders POST request",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Run_Orders_POST"
    },
    {
      "name": "@Run_Orders_POST_1"
    }
  ]
});
formatter.step({
  "name": "I call \u0027gemini new order create and cancel\u0027 webservice",
  "rows": [
    {
      "cells": [
        "request",
        "/v1/order/new"
      ]
    },
    {
      "cells": [
        "request",
        "/v1/order/new"
      ]
    },
    {
      "cells": [
        "nonce",
        "12345"
      ]
    },
    {
      "cells": [
        "symbol",
        "btcusd"
      ]
    },
    {
      "cells": [
        "amount",
        "5"
      ]
    },
    {
      "cells": [
        "price",
        "200"
      ]
    },
    {
      "cells": [
        "client_order_id",
        "1234"
      ]
    },
    {
      "cells": [
        "side",
        "buy"
      ]
    },
    {
      "cells": [
        "type",
        "exchange limit"
      ]
    },
    {
      "cells": [
        "gemini_api_secret",
        "4YgPvW19cb9Ej3GbjnPtNFSxZf6M"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Stepformat.callWebServicesAPI(String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "test Create Orders POST request",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Run_Orders_POST"
    },
    {
      "name": "@Run_Orders_POST_1"
    }
  ]
});
formatter.step({
  "name": "I call \u0027gemini new order create and cancel\u0027 webservice",
  "rows": [
    {
      "cells": [
        "request",
        "/v1/order/new"
      ]
    },
    {
      "cells": [
        "request",
        "/v1/order/new"
      ]
    },
    {
      "cells": [
        "nonce",
        "12346"
      ]
    },
    {
      "cells": [
        "symbol",
        "Ether"
      ]
    },
    {
      "cells": [
        "amount",
        "5"
      ]
    },
    {
      "cells": [
        "price",
        "200"
      ]
    },
    {
      "cells": [
        "client_order_id",
        "2134"
      ]
    },
    {
      "cells": [
        "side",
        ""
      ]
    },
    {
      "cells": [
        "type",
        "exchange limit"
      ]
    },
    {
      "cells": [
        "gemini_api_secret",
        "4YgPvW19cb9Ej3GbjnPtNFSxZf6M"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Stepformat.callWebServicesAPI(String,DataTable)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Status code : 400\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.WebServiceDriver.TMRESTCall(WebServiceDriver.java:55)\r\n\tat com.NewOrderAPI.ordersCreate(NewOrderAPI.java:123)\r\n\tat com.WebServiceCalls.execGeminiRESTAPI(WebServiceCalls.java:40)\r\n\tat com.WebServiceCalls.executeRESTAPI(WebServiceCalls.java:26)\r\n\tat com.Stepformat.callWebServicesAPI(Stepformat.java:17)\r\n\tat ✽.I call \u0027gemini new order create and cancel\u0027 webservice(file:src/test/resources/com/features/geminiassignment.feature:49)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "test Create Orders POST request",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Run_Orders_POST"
    },
    {
      "name": "@Run_Orders_POST_1"
    }
  ]
});
formatter.step({
  "name": "I call \u0027gemini new order create and cancel\u0027 webservice",
  "rows": [
    {
      "cells": [
        "request",
        "/v1/order/new"
      ]
    },
    {
      "cells": [
        "request",
        "/v1/order/new"
      ]
    },
    {
      "cells": [
        "nonce",
        "12347"
      ]
    },
    {
      "cells": [
        "symbol",
        "Ether,btcusd"
      ]
    },
    {
      "cells": [
        "amount",
        "5"
      ]
    },
    {
      "cells": [
        "price",
        "200"
      ]
    },
    {
      "cells": [
        "client_order_id",
        "2134"
      ]
    },
    {
      "cells": [
        "side",
        "sell"
      ]
    },
    {
      "cells": [
        "type",
        "exchange limit"
      ]
    },
    {
      "cells": [
        "gemini_api_secret",
        "4YgPvW19cb9Ej3GbjnPtNFSxZf6M"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Stepformat.callWebServicesAPI(String,DataTable)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Status code : 400\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.WebServiceDriver.TMRESTCall(WebServiceDriver.java:55)\r\n\tat com.NewOrderAPI.ordersCreate(NewOrderAPI.java:123)\r\n\tat com.WebServiceCalls.execGeminiRESTAPI(WebServiceCalls.java:40)\r\n\tat com.WebServiceCalls.executeRESTAPI(WebServiceCalls.java:26)\r\n\tat com.Stepformat.callWebServicesAPI(Stepformat.java:17)\r\n\tat ✽.I call \u0027gemini new order create and cancel\u0027 webservice(file:src/test/resources/com/features/geminiassignment.feature:49)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "test Create Orders POST request",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Run_Orders_POST"
    },
    {
      "name": "@Run_Orders_POST_1"
    }
  ]
});
formatter.step({
  "name": "I call \u0027gemini new order create and cancel\u0027 webservice",
  "rows": [
    {
      "cells": [
        "request",
        "/v1/order/new"
      ]
    },
    {
      "cells": [
        "request",
        "/v1/order/new"
      ]
    },
    {
      "cells": [
        "nonce",
        "12348"
      ]
    },
    {
      "cells": [
        "symbol",
        "Ether,btcusd"
      ]
    },
    {
      "cells": [
        "amount",
        "5"
      ]
    },
    {
      "cells": [
        "price",
        "200"
      ]
    },
    {
      "cells": [
        "client_order_id",
        "2134"
      ]
    },
    {
      "cells": [
        "side",
        ""
      ]
    },
    {
      "cells": [
        "type",
        "exchange limit"
      ]
    },
    {
      "cells": [
        "gemini_api_secret",
        "4YgPvW19cb9Ej3GbjnPtNFSxZf6M"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Stepformat.callWebServicesAPI(String,DataTable)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Status code : 400\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.WebServiceDriver.TMRESTCall(WebServiceDriver.java:55)\r\n\tat com.NewOrderAPI.ordersCreate(NewOrderAPI.java:123)\r\n\tat com.WebServiceCalls.execGeminiRESTAPI(WebServiceCalls.java:40)\r\n\tat com.WebServiceCalls.executeRESTAPI(WebServiceCalls.java:26)\r\n\tat com.Stepformat.callWebServicesAPI(Stepformat.java:17)\r\n\tat ✽.I call \u0027gemini new order create and cancel\u0027 webservice(file:src/test/resources/com/features/geminiassignment.feature:49)\r\n",
  "status": "failed"
});
});