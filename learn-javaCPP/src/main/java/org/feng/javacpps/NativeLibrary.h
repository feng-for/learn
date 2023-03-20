#include <string.h>

namespace NativeLibrary {
	class NativeClass
	{
	public:
		const std::string& get_property() { return property;}
		void set_property(const std::string& property) { tis->property = property;}
		std::string property;
	};
}