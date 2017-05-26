productApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/showProduct/:productId', {
		templateUrl : 'productById.html',
		controller : 'ShowProductController'
	}).when('/editProduct/:productId', {
		templateUrl : 'editProductById.html',
		controller : 'EditProductController'
	}).when('/addNewProduct', {
		templateUrl : 'editProductById.html',
		controller : 'AddProductController'
	}).otherwise({
		redirectTo : '/'
	});
} ]);

productApp.controller('ShowProductController', function($scope, $http,
		$routeParams) {
	var id = $routeParams.productId;
	$scope.productId = id;

	/** get product by id * */
	$http.get("http://localhost:8182/HelloWebApp/product-" + id + "-show.rest")
			.then(function(product) {
				$scope.productSlnum = product.data.productSlnum;
				$scope.productName = product.data.productName;
				$scope.productPrice = product.data.productPrice;
			});

});

productApp.controller('EditProductController', function($scope, $http,
		$routeParams) {
	var id = $routeParams.productId;
	$scope.productId = id;
	$scope.message = 'Displaying Product for';
	/** get product by id * */
	$http.get("http://localhost:8182/HelloWebApp/product-" + id + "-show.rest")
			.then(function(product) {
				$scope.productSlnum = product.data.productSlnum;
				$scope.productName = product.data.productName;
				$scope.productPrice = product.data.productPrice;
			});

});

productApp.controller('AddProductController', function($scope) {
	$scope.message = 'Add new Product';
	$scope.productSlnum = '';
	$scope.productName = '';
	$scope.productPrice = '';
});
