# 📘 Codex Document Validator

Codex is an intelligent Spring Boot-based document validation engine designed for regulated industries (e.g., pharma). It uses LangChain4j (v1.0.1) and supports multiple LLM backends: **Azure OpenAI**, **OpenAI**, and **Ollama**.  
The engine performs guideline-based validation on investigation reports (e.g., deviations, CAPAs) and returns structured, explainable output.

## ✅ Features

- Validate investigation documents against **user-provided system prompts**
- Supports all required QA documentation checks:
  - Description (Who, What, When, Where, How Many, SOP deviation)
  - Initial and Final Impact Assessments
  - Immediate Actions
  - Chronology and Background
  - Root Cause Analysis (RCA)
  - Risk Evaluation & Disposition
  - CAPA Effectiveness, Re-occurrence Trends
- Returns structured JSON suitable for downstream workflows (e.g., QMS systems)
- Supports multiple LLM backends:
  - 🔷 Azure OpenAI
  - 🔓 OpenAI
  - 🐘 Ollama (local models)

---

## 🚀 Tech Stack

| Component         | Version        |
|------------------|----------------|
| Java             | 17             |
| Spring Boot      | 3.4.4          |
| LangChain4j      | 1.0.1          |
| Azure OpenAI     | Supported ✅   |
| OpenAI API       | Supported ✅   |
| Ollama (local)   | Supported ✅   |

---

## 🧠 System Prompt Usage

Unlike hardcoded prompts, Codex accepts **custom system prompts at runtime**.  
This allows full flexibility to validate against different SOPs, regulatory formats, or domains.

### Example

```json
{
  "systemPrompt": "You are a quality assurance expert. Validate the given document based on these guidelines: ...",
  "guideLineText" : "Follow these guidelines..",
  "documentText": "This deviation report describes..."
}

The system prompt should clearly instruct the LLM to return structured JSON in this format:

{
  "validationStatus": "Compliant",
  "complianceBreakdown": {
    "description": "complete",
    "impactAssessment": "missing immediate action section"
  },
  "recommendations": [
    "Add SOP reference in description",
    "Include batch reconciliation quantities in final disposition"
  ]
}


Featuers:

Docx/PDF parsing
Confidence scoring per section
Guided prompt builder for users
Admin UI for report review and approval
CAPA linking & effectivity dashboard


## 🏃‍♂️ Running Locally

Build and start the application:

```bash
mvn spring-boot:run
```

The service exposes a POST `/api/validate` endpoint. Example payload:

```json
{
  "systemPrompt": "You are a quality assurance expert...",
  "guideLineText": "Follow these guidelines...",
  "documentText": "This deviation report describes..."
}
```
