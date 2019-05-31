pragma solidity 0.4.24;

contract TrustFarmInterface {
    function changeProductCertification(string _productId, bool _isCertificated) external returns (bool);
}

contract TrustFarmOrg1 {
    address trustFarmAddress = 0xaE4DAf6c9874dfCc6Db77174016520f1a2489629;
    TrustFarmInterface trustFarmContract = TrustFarmInterface(trustFarmAddress);

    function assignCertification(string _productId, bool _isCertificated) public {
        trustFarmContract.changeProductCertification(_productId, _isCertificated);
    }
}