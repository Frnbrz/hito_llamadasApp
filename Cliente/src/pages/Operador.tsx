import {AppBar, OperadorForm} from "@/components";

function Operador() {
    return (
        <>
            <AppBar/>
            <div className="container mx-auto px-4 sm:px-8">
                <OperadorForm/>
            </div>
        </>
    );
}

export default Operador;