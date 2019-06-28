#include <QString>
#include <iostream>
#include "ApiFuncionario_types.h"

using namespace std;
using namespace ::Thrift;

/*Estatus
 * 0 = Correcto
 * 1 = Error
 */

struct FuncionarioR{
    Funcionario funcionario;
    bool estatus;
};

struct ListaFuncionarioR{
    vector<Funcionario> funcionarios;
    bool estatus;
};

struct ListaReportesR{
    vector<Reporte> reportes;
    bool estatus;
};

struct ReporteR{
    Reporte reporte;
    bool estatus;
};

struct DictamenR{
    Dictamen dictamen;
    bool estatus;
};


struct VehiculoReporteR{
    int vehiculo1;
    int vehiculo2;
    int idreporte;
    bool estatus;
};

struct VehiculoReporteMatriculasR{
    QString placa1;
    QString placa2;
    QString idreporte;
    bool estatus;
};

struct VehiculoR{
    QString placa;
    bool estatus;
};

struct ListaVehiculoReporteR{
    vector<VehiculoReporteR> vehiculoReportes;
    bool estatus;
};

struct ListaVehiculosMatriculasR{
    vector<VehiculoReporteMatriculasR> vehiculos;
    bool estatus;
};

struct IntR{
    int respuesta;
    bool estatus;
};


struct BoolR{
    bool respuesta;
    bool estatus;
};
