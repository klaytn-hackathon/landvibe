// Klaytn IDE uses solidity 0.4.24 version.
pragma solidity 0.4.24;
pragma experimental ABIEncoderV2;

contract OwnerCheck {
    address public owner;
    
    function OwnerCheck() public {
        owner = msg.sender;
    }

    modifier contractOwner() {
        require(owner == msg.sender);
        _;
    }
}

library Library {
  struct data {
     uint val;
     bool isValue;
   }
}

contract TrustFarm is OwnerCheck {
    uint8 organizationCount = 0;

    event RegisterOrganization(uint id, string code);
    event CertificationChanged(string productId, bool isCertifiacted, address organizationAddress);

    using Library for Library.data;
    mapping (address => Library.data) organizationIndex;
    mapping (address => uint) organizationCertificationCount;
    mapping (string => uint) productIndex;

    struct Organization {
        address owner;
        string code;
        string name;
    }

    struct Certification {
        Organization organization;
        bool isCertifiacated;
    }

    struct Product {
        address owner;
        string id;
        uint8 certificationCount;
        mapping(uint => Certification) certifications;
    }

    Organization[] organizations;
    Product[] products;

    function addOrganization(address _owner, string _code, string _name) external contractOwner returns (uint) {
        if (organizationIndex[_owner].isValue) {
            return organizationIndex[_owner].val;
        }

        uint index = organizations.push(Organization(_owner, _code, _name)) - 1;
        organizationIndex[_owner].val = index;
        organizationIndex[_owner].isValue = true;
        organizationCount++;
        emit RegisterOrganization(index, _code);
        return index;
    }

    function addProduct(string _id) external {
        uint index = products.push(Product(msg.sender, _id, 0)) - 1;
        productIndex[_id] = index;
    }

    function getProductCertification(string _productId) public view returns (Certification[] memory) {
        uint index = productIndex[_productId];
        Product product = products[index];

        Certification[] memory certifications = new Certification[](product.certificationCount);
        for (uint i = 0; i < product.certificationCount; i++) {
            certifications[i] = product.certifications[i];
        }

        return certifications;
    }

    function changeProductCertification(string _productId, bool _isCertificated) external returns (bool) {
        if (organizationIndex[msg.sender].isValue) {
            Organization organization = organizations[organizationIndex[msg.sender].val];
            Certification memory certification = Certification(organization, _isCertificated);

            if (_isCertificated) {
                organizationCertificationCount[msg.sender]++;
            } else {
                organizationCertificationCount[msg.sender]--;
            }

            uint index = productIndex[_productId];
            uint certificationCount = products[index].certificationCount;
            products[index].certifications[certificationCount] = certification;
            emit CertificationChanged(_productId, _isCertificated, msg.sender);
            return true;
        } 

        return false;
    }

    function getOrganizationCount() public view returns (uint) {
        return organizationCount;
    }

    function getProductCount() public view returns (uint) {
        return products.length;
    }
}

