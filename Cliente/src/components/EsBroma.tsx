function EsBroma({handleChange}: { handleChange: (event: React.ChangeEvent<HTMLSelectElement>) => void }) {
    return (
        <>
            <label htmlFor="deriba" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-800">¿Es
                broma?</label>
            <select onChange={handleChange} id="deriba"
                    className="py-3 px-4 pe-9 block w-full rounded-lg text-sm focus:border-blue-500 focus:ring-blue-500 disabled:opacity-50 disabled:pointer-events-none bg-blue-50 border-gray-800 text-black">
                <option value=""></option>
                <option value="1">Si</option>
                <option value="0">No</option>
            </select>
        </>
    );
}

export default EsBroma;