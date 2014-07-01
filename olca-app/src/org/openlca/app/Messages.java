package org.openlca.app;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.osgi.util.NLS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class Messages extends NLS {

	public static String AccessAndUseRestrictions;
	public static String Actor;
	public static String Actors;
	public static String Actors_WizardMessage;
	public static String Actors_WizardTitle;
	public static String Add;
	public static String AddAction_Text;
	public static String AdditionalInfo;
	public static String Address;
	public static String AdminInfoPageLabel;
	public static String AllocationMethod;
	public static String Amount;
	public static String AsDefinedInProcesses;
	public static String Author;
	public static String AvoidedProduct;
	public static String BuildNextTier;
	public static String Calculate;
	public static String CalculateCosts;
	public static String CalculateDefaults;
	public static String CalculationWizardDescription;
	public static String CalculationWizardPage_Analysis;
	public static String CalculationWizardPage_CalculationType;
	public static String CalculationWizardPage_NumberOfIterations;
	public static String CalculationWizardPage_QuickResults;
	public static String CalculationWizardTitle;
	public static String CasNumber;
	public static String Category;
	public static String Causal;
	public static String CheckForUpdates;
	public static String ChooseDirectoryButton;
	public static String ChooseDirectoryLabel;
	public static String City;
	public static String Code;
	public static String Complete;
	public static String CompleteRefData;
	public static String ConnectProviders;
	public static String ConnectRecipients;
	public static String ConsumedBy;
	public static String Context;
	public static String Contribution;
	public static String ConversionFactor;
	public static String Copy;
	public static String Copyright;
	public static String Country;
	public static String CreateProductFlow;
	public static String CreateProductSystem;
	public static String CreationDate;
	public static String Cut;
	public static String CutOff;
	public static String Daily;
	public static String Database;
	public static String DatabaseImport;
	public static String DatabaseImportDescription;
	public static String DataCollectionPeriod;
	public static String DataCompleteness;
	public static String DataDocumentor;
	public static String DataGenerator;
	public static String DataSelection;
	public static String DatasetOtherEvaluation;
	public static String DataSetOwner;
	public static String DataSourceInfoSectionLabel;
	public static String DataTreatment;
	public static String DefaultMethod;
	public static String DefaultFlowProperty;
	public static String DefaultProvider;
	public static String Delete;
	public static String DeleteDatabase;
	public static String DeleteWizard_Analyzing;
	public static String DeleteWizard_Solving;
	public static String DeleteWizard_WindowTitle;
	public static String Description;
	public static String Direction;
	public static String Doi;
	public static String Economic;
	public static String EcoSpoldCreatingFolder;
	public static String EcoSpoldExporting;
	public static String EcoSpoldExportWizard_WindowTitle;
	public static String EcoSpoldImportWizard_WindowTitle;
	public static String Edit;
	public static String ElementaryFlow;
	public static String EMail;
	public static String EmptyDatabase;
	public static String EmptyQuantitativeReferenceError;
	public static String EmptyReferenceFlowPropertyError;
	public static String EmptyReferenceUnitError;
	public static String EndDate;
	public static String English;
	public static String Error;
	public static String EvaluationSectionLabel;
	public static String Export;
	public static String ExportTo;
	public static String ExportToExcel;
	public static String ExportDatabase;
	public static String Factor;
	public static String FancyToolTip_NoDescription;
	public static String File;
	public static String FileAlreadyExists;
	public static String FileImportPage_ChooseDirectoryButton;
	public static String FileImportPage_ChooseDirectoryLabel;
	public static String FileImportPage_Description;
	public static String FileImportPage_Title;
	public static String Filter;
	public static String Flow;
	public static String FlowContributions;
	public static String FlowProperties;
	public static String FlowPropertiesPageLabel;
	public static String FlowProperty;
	public static String FlowProps_EmptyUnitGroupError;
	public static String FlowProps_FlowPropertyType;
	public static String FlowProps_WizardMessage;
	public static String FlowProps_WizardTitle;
	public static String Flows;
	public static String Flows_WizardMessage;
	public static String Flows_WizardTitle;
	public static String FlowType;
	public static String Formula;
	public static String FunctionalUnit;
	public static String GeneralInformation;
	public static String GeographyInfoSectionLabel;
	public static String GeometricMean;
	public static String GeometricStandardDeviation;
	public static String German;
	public static String Global;
	public static String GlobalParameters;
	public static String GlobalParametersPreferencePage_Title;
	public static String Goal;
	public static String GoalAndScopeInfoSectionLabel;
	public static String Group;
	public static String Grouping;
	public static String Groups;
	public static String Hourly;
	public static String ILCDExportWizard_WindowTitle;
	public static String ILCDImportWizard_WindowTitle;
	public static String ImpactCategories;
	public static String ImpactCategory;
	public static String ImpactContributions;
	public static String ImpactFactors;
	public static String ImpactMethod;
	public static String ImpactMethods;
	public static String ImpactMethodTitle;
	public static String Import;
	public static String ImportDatabase;
	public static String INFO;
	public static String InfrastructureProcess;
	public static String InputOutputPageLabel;
	public static String Inputs;
	public static String IntendedApplication;
	public static String IsInfrastructureFlow;
	public static String IsReference;
	public static String Language;
	public static String LanguagePreferencePage_SelectLanguageLabel;
	public static String LanguagePreferencePage_SelectLanguageNoteText;
	public static String LanguagePreferencePage_Title;
	public static String LastChange;
	public static String LastModificationDate;
	public static String Latitude;
	public static String LCI;
	public static String LCIMethod;
	public static String Location;
	public static String Locations;
	public static String LogNormalDistribution;
	public static String Longitude;
	public static String Map;
	public static String Maximum;
	public static String Mean;
	public static String Menu_File;
	public static String Menu_Help;
	public static String Menu_ShowViews;
	public static String Menu_Window;
	public static String Methods_WizardMessage;
	public static String Methods_WizardTitle;
	public static String Minimum;
	public static String Mode;
	public static String ModelGraph;
	public static String ModelingAndValidationPageLabel;
	public static String ModelingConstants;
	public static String MonteCarloSimulation;
	public static String Monthly;
	public static String Move;
	public static String Name;
	public static String NavigationView_AddCategoryText;
	public static String NavigationView_DeleteQuestion;
	public static String NavigationView_NewCategoryDialogDefault;
	public static String NavigationView_NewCategoryDialogText;
	public static String NavigationView_NewCategoryDialogTitle;
	public static String NavigationView_NoButton;
	public static String NavigationView_RemoveCategoryText;
	public static String PleaseEnterNewName;
	public static String Rename;
	public static String NavigationView_YesButton;
	public static String Never;
	public static String NewDatabase;
	public static String NewDatabase_AlreadyExists;
	public static String NewDatabase_Create;
	public static String NewDatabase_Description;
	public static String NewDatabase_InvalidName;
	public static String NewDatabase_Name;
	public static String NewDatabase_NameToShort;
	public static String NewDatabase_RefData;
	public static String NoDistribution;
	public static String None;
	public static String NormalDistribution;
	public static String Normalization;
	public static String NormalizationFactor;
	public static String NormalizationWeightingPageLabel;
	public static String NormalizationWeightingSet;
	public static String NormalizationWeightingSets;
	public static String Note;
	public static String NumberFormatPage_Description;
	public static String NumberFormatPage_Example;
	public static String NumberFormatPage_NumberOfPlaces;
	public static String NWSet;
	public static String OnlineHelp;
	public static String Open;
	public static String OpenEditorAction_Text;
	public static String OpenLCAUpdateCheckJobname;
	public static String Outputs;
	public static String OverwriteFileQuestion;
	public static String Parameter;
	public static String Parameters;
	public static String Paste;
	public static String PedigreeUncertainty;
	public static String Physical;
	public static String PleaseEnterName;
	public static String ProblemsPage_FoundProblems;
	public static String Process;
	public static String ProcessContributions;
	public static String Processes;
	public static String Processes_WizardMessage;
	public static String Processes_WizardTitle;
	public static String ProcessType;
	public static String ProducedBy;
	public static String ProductFlow;
	public static String Product;
	public static String ProductSystem;
	public static String ProductSystems;
	public static String Progress;
	public static String Project;
	public static String Projects;
	public static String ProjectInfoSectionLabel;
	public static String Projects_WizardMessage;
	public static String Projects_WizardTitle;
	public static String Properties;
	public static String Publication;
	public static String QuantitativeReference;
	public static String ReferenceFlowProperty;
	public static String ReferenceProcess;
	public static String ReferenceUnit;
	public static String Reload;
	public static String RemoveAction_Text;
	public static String Report;
	public static String ReportParameters;
	public static String Reserve;
	public static String Reset;
	public static String Rest;
	public static String ResultContributions;
	public static String ResultOf;
	public static String Results;
	public static String ResultsOf;
	public static String Reviewer;
	public static String Sampling;
	public static String Sankey_ActionText;
	public static String Sankey_Cutoff;
	public static String Sankey_DialogDescription;
	public static String Sankey_NoOptions;
	public static String Sankey_SavingAsImage;
	public static String Sankey_ScaleDescription;
	public static String Save;
	public static String SaveAs;
	public static String SaveAsImage;
	public static String SaveChanges;
	public static String SaveChangesQuestion;
	public static String SaveDefaults;
	public static String Search;
	public static String Searching;
	public static String SelectExportFile;
	public static String SelectObjectPage_Description;
	public static String SelectObjectPage_Title;
	public static String SelectParameter;
	public static String Settings;
	public static String ShowFormulas;
	public static String ShowValues;
	public static String Simulation_NumberOfSimulations;
	public static String SingleAmount;
	public static String Source;
	public static String SourceInfoSectionLabel;
	public static String Sources;
	public static String Sources_WizardMessage;
	public static String Sources_WizardTitle;
	public static String SourcesInfoSectionLabel;
	public static String StandardDeviation;
	public static String Start;
	public static String StartDate;
	public static String SubCategory;
	public static String Synonyms;
	public static String SystemProcess;
	public static String Systems_AddSupplyChain;
	public static String Systems_AppActionBarContributorClass_LayoutActionText;
	public static String Systems_AvoidedProductFlow;
	public static String Systems_AvoidedWasteFlow;
	public static String Systems_BuildSupplyChainAction_Text;
	public static String Systems_CalculateButtonText;
	public static String Systems_CreatingProductSystem;
	public static String Systems_EmptyReferenceProcessError;
	public static String Systems_ExpandAllQuestion_Title;
	public static String Systems_ExpandAllQuestion_Text;
	public static String Systems_ExpandAllAction_Text;
	public static String Systems_ExpansionCommand_ExpandText;
	public static String Systems_ExpansionCommand_CollapseText;
	public static String Systems_CollapseAllAction_Text;
	public static String Systems_GetLinksAction_ProviderText;
	public static String Systems_GetLinksAction_RecipientText;
	public static String Systems_GraphLayoutType_MinimalTree;
	public static String Systems_GraphLayoutType_Tree;
	public static String Systems_HideShowAction_HideText;
	public static String Systems_HideShowAction_ShowText;
	public static String Systems_HideShowCommand_HideText;
	public static String Systems_HideShowCommand_ShowText;
	public static String Systems_LayoutAction_Text;
	public static String Systems_LayoutCommand_LayoutText;
	public static String Systems_MarkProcess;
	public static String Systems_MatrixExportAction_Text;
	public static String Systems_MaximizeAllProcessesAction_Text;
	public static String Systems_MaximizeCommand_Text;
	public static String Systems_MinimizeAllProcessesAction_Text;
	public static String Systems_MinimizeCommand_Text;
	public static String Systems_OpenMiniatureViewAction_Text;
	public static String Systems_Prefer;
	public static String Systems_ProcessCreateCommand_Text;
	public static String Systems_ProcessDeleteCommand_Text;
	public static String Systems_ProcessLinkCreateCommand_Text;
	public static String Systems_ProcessLinkDeleteCommand_Text;
	public static String Systems_ProcessLinkReconnectCommand_Text;
	public static String Systems_ProductSystemGraphEditor_FilterLabel;
	public static String Systems_ProductSystemInfoSectionLabel;
	public static String Systems_RemoveAllConnectionsAction_Text;
	public static String Systems_RemoveSupplyChainAction_Text;
	public static String Systems_Route;
	public static String Systems_SelectPossibleProcessesDialog_Connect;
	public static String Systems_SelectPossibleProcessesDialog_Create;
	public static String Systems_SelectPossibleProcessesDialog_Exists;
	public static String Systems_SelectPossibleProcessesDialog_IsConnected;
	public static String Systems_SelectPossibleProcessesDialog_SelectProviders;
	public static String Systems_SelectPossibleProcessesDialog_SelectRecipients;
	public static String Systems_ShowOutlineAction_Text;
	public static String Systems_UnmarkProcess;
	public static String Systems_UseSystemProcesses;
	public static String Systems_WizardMessage;
	public static String Systems_WizardTitle;
	public static String Systems_XYLayoutCommand_MoveText;
	public static String Systems_XYLayoutCommand_ResizeText;
	public static String TargetAmount;
	public static String TechnologyInfoSectionLabel;
	public static String Telefax;
	public static String Telephone;
	public static String TextDropComponent_RemoveButtonText;
	public static String TextDropComponent_ToolTipText;
	public static String TextReference;
	public static String TimeInfoSectionLabel;
	public static String TotalAmount;
	public static String TriangleDistribution;
	public static String UIFactory_CategoryLabel;
	public static String Uncertainty;
	public static String UncertaintyDistribution;
	public static String UniformDistribution;
	public static String Unit;
	public static String UnitExists;
	public static String UnitExistsError;
	public static String UnitGroup;
	public static String UnitGroupInfoSectionLabel;
	public static String UnitGroups;
	public static String UnitMappingPage_CheckingUnits;
	public static String UnitMappingPage_Description;
	public static String UnitMappingPage_Title;
	public static String UnitProcess;
	public static String Units_WizardMessage;
	public static String Units_WizardTitle;
	public static String UnitsAndFlowProps;
	public static String UpdatePreferences;
	public static String Usage;
	public static String UsageOf;
	public static String UsedInProcesses;
	public static String UserFriendlyName;
	public static String Value;
	public static String Version;
	public static String Warning;
	public static String WasteFlow;
	public static String WebSite;
	public static String Weekly;
	public static String Weighting;
	public static String WeightingFactor;
	public static String Year;
	public static String ZipCode;
	public static String Unknown;
	public static String CreateNewLCIAMethod;
	public static String CreateNewActor;
	public static String CreateNewFlow;
	public static String CreateNewFlowProperty;
	public static String CreateNewProcess;
	public static String CreateNewProductSystem;
	public static String CreateNewProject;
	public static String CreateNewSource;
	public static String CreateNewUnitGroup;

	private static Map<String, String> map;

	static {
		NLS.initializeMessages("org.openlca.app.messages", Messages.class);
	}

	private Messages() {
	}

	public static Map<String, String> getMap() {
		if (map == null)
			map = new HashMap<>();
		try {
			for (Field field : Messages.class.getDeclaredFields()) {
				if (!Objects.equals(field.getType(), String.class))
					continue;
				if (!Modifier.isStatic(field.getModifiers()))
					continue;
				if (!Modifier.isPublic(field.getModifiers()))
					continue;
				String val = (String) field.get(null);
				map.put(field.getName(), val);
			}
		} catch (Exception e) {
			Logger log = LoggerFactory.getLogger(Messages.class);
			log.error("failed to get messages as map", e);
		}
		return map;
	}

	public static String asJson() {
		try {
			Gson gson = new Gson();
			return gson.toJson(getMap());
		} catch (Exception e) {
			Logger log = LoggerFactory.getLogger(Messages.class);
			log.error("failed to get messages as JSON string", e);
			return "{}";
		}
	}
}
