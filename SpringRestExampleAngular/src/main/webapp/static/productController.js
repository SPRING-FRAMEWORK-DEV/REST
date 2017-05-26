

productApp.controller('productController', function($scope, $http) {
  
	/** get all products * */
	$http.get('http://localhost:8182/HelloWebApp/allproducts.rest').then(
      function(products){
    	  console.log("get all data");
        $scope.products = products.data;
      }
    );
	
	$scope.getAllData=function()
	{
		$http.get('http://localhost:8182/HelloWebApp/allproducts.rest').then(
			      function(products){
			    	  console.log("get all data");
			        $scope.products = products.data;
			       
			      }
			    );
	}
	$scope.sendData = function () {
        // use $.param jQuery function to serialize data from JSON
    	console.log('inside sendData');
         var data = {
        	 productSlnum: this.productSlnum,
        	 productName: this.productName,
        	 productPrice: this.productPrice
         };
    
        /*
		 * var config = { headers : { 'Content-Type':
		 * 'application/x-www-form-urlencoded;charset=utf-8;' } }
		 */

         $http.post('http://localhost:8182/HelloWebApp/add-product.rest', data)
         .success(function (data, status) {
             $scope.PostDataResponse = data;
             $scope.getAllData();
         })
         .error(function (data, status) {
             $scope.ResponseDetails = "Data: " + data +
                 "<hr />status: " + status;
         });
     };
   /** remove method * */
    $scope.removeProduct=function(idx,id)
    {
    	// $http.remove("delete-"+id+"-product.rest").then(function(id){alert('deleted')});
    	$http.delete("delete-"+id+"-product.rest")
        .success(function (status, headers) {
            
        	$scope.getAllData();
        	redirectTo : '/'
        })
        .error(function (status, header, config) {
            $scope.ServerResponse = htmlDecode(
                "status: " + status +
                "\n\n\n\nheaders: " + header +
                "\n\n\n\nconfig: " + config);
        });
    	
    	
    };
    
  }
);

