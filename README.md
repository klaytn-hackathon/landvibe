# Klaytn Hackaton
**Demo**
https://youtu.be/fYAMi47_9vU

## TrustFarm by Team LandVibe.

### 1. Project Summary
**Project Name**
- Trust Farm


**Why can we start this project?**
- Are you wondering how the fruit in front of us was raised? Was it safely raised? In times of cheap foreign agricultural products, consumers crave safe food that they can trust and eat.
Our team proposes block-chain-based plant growth image generation technology. And a new block-chain platform based on it

**Project Description**
- A new block-chain platform that connects sellers who produce fruits and vegetables with consumers who want to buy them. The fruits and vegetables must be certified by an accredited agency, which is recorded in the block chain. The seller records the time-lapse during the growing period of fruits, vegetables, etc. To inform the consumer, and the consumer chooses the goods to buy based on this.

**Key Feature**
- fruit/plant certification
- fruit/plant growth image generation -> timelapse
    - it used camera which takes photo daily in the farm

### 2. TrustFarm Contracts
In klaytn baobab network, Retains authentication information about the product. It is possible to challenge the consumer through this authentication information camouflage.

![TrustFarm contracts](http://landvibe.cafe24.com/img/contract.png)
- TrustFarm Contract Address : 0x4Cbb5e6295be5f4FB31dD53c5b752090b3Ec7908
    - addOrganization
    - getProductCertification
- Organization Contract Address : 0xD9ab3DfA4FFeA1E884D90b4C55409a9352B0A013
    - addProductCertification
    - removeProductCertification
- Farmer Contract Address : 0x188f616A6F64244BABefc000c45795887E229538
    - addProduct
    - removeProduct

### 3. TrustFarm IOT
![Trust Farm IOT](http://landvibe.cafe24.com/img/trustfarm_iot.png)

### 4. TrustFarm Service
**Our service intro**
![Trust Farm Intro](http://landvibe.cafe24.com/img/trustfarm_intro.png)

**Product list for customer**
![Trust Farm Product List](http://landvibe.cafe24.com/img/trustfarm_product.png)

**Product Detail for customer**
![Trust Farm Item Detail View](http://landvibe.cafe24.com/img/trustfarm_product_detail.png)

**Product timelapse uploaded by farmer**

![Trust Farm Item View](http://landvibe.cafe24.com/img/trustfarm-growth.gif)

### 5. Forward Plan
We made a toy project-level output to confirm the possibility as a service on the block chain

**Prepare the following features**
- klaytn wallet login
- buy product by klay
- provide customers' purchase information and history
- contact with more farmers and actual certification body (maybe.. it takes a lot of time)


### Conclusion...
This is our first attempt at the team and is still incomplete. We are going to finish this gradually.

Thanks for reading :)
