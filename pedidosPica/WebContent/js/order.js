var app = angular.module('orders', [ "ngResource", "ui.bootstrap"]);

app.controller('ordersController', [ '$scope', '$http',
                                     
	function($scope, $http) {
		
		$scope.loadProducts = function() {
			$scope.myInterval = 3000;
			$scope.slides = [
				{ image: 'http://lorempixel.com/400/200/' },
				{ image: 'http://lorempixel.com/400/200/food' },
				{ image: 'http://lorempixel.com/400/200/sports'},
				{ image: 'http://lorempixel.com/400/200/people'}
			];
		}

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