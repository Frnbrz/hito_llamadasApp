import {AppBar, EspecialistaForm} from "@/components";

function Especialista() {
    return (
        <>
            <AppBar/>
            <div className="container mx-auto px-4 sm:px-8">
                <EspecialistaForm/>
            </div>
        </>
    );
}

export default Especialista;