/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("viajeroModule", ["ui.bootstrap"]);
    mod.constant("viajeroContext", "http://localhost:8080/misVacaciones.web/api/viajeros");

})(window.angular);

