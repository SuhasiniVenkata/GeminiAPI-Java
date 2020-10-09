# GeminiAPI-Java

Background:
Gemini is a digital asset exchange. Customers can buy and sell Bitcoin, Ether, and Zcash for US Dollars. 
For sophisticated customers, Gemini provides a REST API so that customers can place and cancel orders programmatically.

The Solution:
- Created functional test cases in Java
- Included both positive and negative cases 
Positive Test Cases And Negative Test cases: - 
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
