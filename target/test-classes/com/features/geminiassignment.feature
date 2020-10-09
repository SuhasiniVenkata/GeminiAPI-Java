@Run_Orders_POST
Feature: Automation tests for placing new orders and cancel the orders
  Description: The purpose of these tests are to cover customer place new order and cancel the orders

  #cancel all orders opened by this session
  @Test2
  Scenario: test cancel Orders POST request
    Given I call 'gemini new order create and cancel' webservice
      | request           | /v1/order/cancel/session     |
       | request           | /v1/order/cancel/session     |
      | nonce             |                        32121 |
      | gemini_api_secret | 4YgPvW19cb9Ej3GbjnPtNFSxZf6M |

  #cancel all orders by account
  @Test1
  Scenario: test cancel Orders POST request
    Given I call 'gemini new order create and cancel' webservice
      | request           | /v1/order/cancel/all         |
      | nonce             |                        21211 |
      | gemini_api_secret | 4YgPvW19cb9Ej3GbjnPtNFSxZf6M |

  #cancel all orders by OrderID
  #Try cancelling other customer OrderIDs
  @Test
  Scenario: test cancel Orders POST request
    Given I call 'gemini new order create and cancel' webservice
      | request           | /v1/order/cancel             |
      | nonce             |                        21211 |
      | order_id          | id                           |
      | gemini_api_secret | 4YgPvW19cb9Ej3GbjnPtNFSxZf6M |

  # create new orders for Bitcoin, Ether, and Zcash with US Dollers
  # create new orders for Bitcoin, Ether, and Zcash with other than US Dollers
  # create(buy) new orders for the same client_order_id
  # create new order for the qty more than available
  # create single order for combination of digital currency (ex: Bitcoin and Ether, Ether, and Zcash )
  # create new orders with US Dollers other than  Bitcoin, Ether, and Zcash
  # verify the error codes for missing headers
  # verify unauthenticated user able to access the apis
  # create multiple orders with in the same payload
  # verify selling  digital currency (Bitcoin, Ether, and Zcash)  with US Dollers
  # verify selling  digital currency (Bitcoin, Ether, and Zcash)  other than US Dollers
  # Verify selling same orders to multiple clients
  # verify successful sell
  # verify selling qty more than available
  # verify sell and buy happening at the stop_price
  @Run_Orders_POST_1
  Scenario Outline: test Create Orders POST request
    Given I call 'gemini new order create and cancel' webservice
      | request           | /v1/order/new                |
      | request           | /v1/order/new                |
      | nonce             | <nonce>                      |
      | symbol            | <symbol>                     |
      | amount            | <amount>                     |
      | price             |                          200 |
      | client_order_id   | <client_order_id>            |
      | side              | <side>                       |
      | type              | <type>                       |
      | gemini_api_secret | 4YgPvW19cb9Ej3GbjnPtNFSxZf6M |

    Examples: 
      | nonce | symbol | amount | side | client_order_id | type           |
      | 12345 | btcusd |      5 | buy  |            1234 | exchange limit |
      | 12346 | Ether         |      5 |      |            2134 | exchange limit |
      | 12347 | Ether,btcusd |      5 | sell |            2134 | exchange limit |
      | 12348 | Ether,btcusd |      5 |      |            2134 | exchange limit |
