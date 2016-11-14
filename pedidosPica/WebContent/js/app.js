var app = angular.module('app', [ "ngRoute", "ngResource", "ui.bootstrap"]);


app.config(function($routeProvider){
	$routeProvider
		.when("/", {
			templateUrl: "pages/blank.html"
		})
		.when("/orders", {
			//controller: "ordersController",
			//controllerAs: "ordersController",
			templateUrl: "pages/orders.html"
		})
		.when("/products", {
			//controller: "productsController",
			//controllerAs: "productsController",
			templateUrl: "pages/products.html"
		});
});


app.controller('ordersController', [ '$scope', '$http',
                                     
	function($scope, $http) {
		
		$scope.getOrders = function() {
			$http.get('/pedidosPica/rest/orders/get').success(function(data) {
				$scope.orders = data;
			});
		}
		 
		$scope.addOrder = function() {
			$http.post('/pedidosPica/rest/orders/add', {
				'user': $scope.current.user,
				'product':{id:$scope.current.productId},
				'cant': $scope.current.cant
				
			}).success(function(data) {
				$scope.msg = 'Pedido realizado correctamente';
				$scope.getOrders(); // reload
			}).error(function(data) {
				$scope.msg = 'Se ha producido un error';
			});
		}
} ]);

app.controller('productsController', [ '$scope', '$http',
                                     
	function($scope, $http) {
		
		$scope.loadProducts = function() {
			$scope.myInterval = 3000;
			$scope.noWrapSlides = false;
  			$scope.active = 0;
			$http.get('/pedidosPica/rest/products/get').success(function(data) {
				$scope.products = data;
			});
		}

} ]);