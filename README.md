# api-gateway

This module acts as the api-gateway for both the order-service and batch microservices. All incoming requests can come through this module so that proper validations or authentication is done once added. More microservices could be added later and routed through the same gateway.

It is exposed on port 8080 and is accessible by swagger.
