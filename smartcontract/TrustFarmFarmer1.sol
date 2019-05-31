pragma solidity 0.4.24;

contract TrustFarmInterface {
    function addProduct(string _id) external;
}

contract TrustFarmFarmer1 {
    address trustFarmAddress = 0xaE4DAf6c9874dfCc6Db77174016520f1a2489629;
    TrustFarmInterface trustFarmContract = TrustFarmInterface(trustFarmAddress);

    function assignCertification(string _productId) public {
        trustFarmContract.addProduct(_productId);
    }
}
