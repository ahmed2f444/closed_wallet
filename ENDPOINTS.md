# 📌 Complete API List

 Items

POST    /api/items                  → Add item
DELETE  /api/items/{id}             → Delete item
GET     /api/items                  → Get all items

------------------------------------------------------------

 Wallets

POST    /api/wallets/{customerId}   → Create wallet
GET     /api/wallets                → Get all wallets
GET     /api/wallets/{walletId}     → Get wallet by ID
GET     /api/wallets/customer/{id}  → Get wallet by customer ID
PUT     /api/wallets/{walletId}/balance → Update balance
PUT     /api/wallets/{walletId}/status  → Update status
DELETE  /api/wallets/{walletId}     → Delete wallet

------------------------------------------------------------

 Transactions

GET     /api/transactions                       → Get all transactions
GET     /api/transactions/purchases             → Get all purchases
GET     /api/transactions/refunds               → Get all refunds
GET     /api/transactions/customer/{id}         → Get all transactions for a customer
GET     /api/transactions/customer/{id}/purchases → Get purchases for a customer
GET     /api/transactions/customer/{id}/refunds   → Get refunds for a customer
GET     /api/transactions/{refundId}/purchase   → Get purchase for a refund
GET     /api/transactions/{purchaseId}/refunds  → Get refunds for a purchase
