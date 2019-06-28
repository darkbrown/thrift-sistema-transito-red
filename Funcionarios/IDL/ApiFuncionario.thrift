namespace java Thrift
namespace cpp Thrift


struct Funcionario{
	1: string nombre,
	3: i32 estatus,
	4: string cargo,
	5: string usuario, 
	6: string contrasena,
}


struct Reporte{
	1: i32 idreporte,
	2: string latitud,
	3: string longitud,
	4: string nombreOtroConduc,
	5: i32 idconductor,
	6: i32 folioUnico_dictamen,
	7: i32 idFuncionario,
	8: string nombreConductor,
	9: i32 dictamen,
	10: string fecha,
}


struct Dictamen{
	1: string dictamen;
	2: string fecha;
	3: i32 idfuncionario;
	4: i32 idreporte;
	5: i32 folioUnico;
}


 exception ErrorBD {                 
     1: string problema = "Error de conexion",      
     2: i16 codigoError = 500,
 }

 struct VehiculosReporte{
 	1: string placaVehiculo1,
 	2: string placaVehiculo2,
 }




service ApiFuncionario {

	
	//Metodos usuario y funcionarios en general

	bool verificarFuncionario (1:string usuario, 2:string contrasena) throws(1:ErrorBD ebd),

	Funcionario getFuncionario (1:string usuario) throws(1:ErrorBD ebd),

	list<Funcionario> getFuncionarios() throws(1:ErrorBD ebd),

	bool cambiarEstatusFuncionario(1:string usuario) throws(1:ErrorBD ebd),





	//Metodos Perito

	bool modificarPerito(1:Funcionario peritoAnterior, 2:Funcionario peritoNuevo) throws(1:ErrorBD ebd),

	bool cambiarContrasenaPerito(1:string usuario, 2:string contrasena) throws(1:ErrorBD ebd),

	bool registrarPerito (1:Funcionario perito) throws(1:ErrorBD ebd),

	Funcionario getPerito(1:string usuario) throws(1:ErrorBD ebd),

	list<Funcionario> getPeritos() throws(1:ErrorBD ebd),

	i32 getIdPerito(1:string usuario) throws(1:ErrorBD ebd),

	

	//Metodos reportes

	list<Reporte> getReportesPendientes() throws(1:ErrorBD ebd),

	list<Reporte> getReportesAsignados(1:i32 idPerito) throws(1:ErrorBD ebd),

	bool asignarReportePerito(1:i32 idPerito, 2:i32 idReporte) throws(1:ErrorBD ebd),

	Reporte getReporte(1:i32 idReporte) throws(1:ErrorBD ebd),

	//Metodos dictamen

	bool levantarDictamen(1:Dictamen dictamen) throws(1:ErrorBD ebd),

	Dictamen getDictamen(1:i32 idReporte) throws(1:ErrorBD ebd),


	//Placas

	list<VehiculosReporte> getPlacasVehiculosReporte() throws(1:ErrorBD ebd),

	//Imagenes

	bool cargarImagenes(1:list<binary> listaImagenes, 2:i32 idreporte) throws(1:ErrorBD ebd),

	list<binary> getImagenes(1:i32 idreporte) throws(1:ErrorBD ebd),

}