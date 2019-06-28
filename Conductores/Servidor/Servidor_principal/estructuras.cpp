#include <QString>
#include <iostream>
#include "ApiServidor_types.h"

using namespace std;
using namespace ::Thrift;

/*Estatus
 * 0 = correcto
 * 1 = error
 */

struct BoolR{
    bool respuesta;
    bool estatus;
};
